package com.mspr.API;

import com.amazonaws.AmazonClientException;
import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.profile.ProfileCredentialsProvider;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.rekognition.AmazonRekognition;
import com.amazonaws.services.rekognition.AmazonRekognitionClientBuilder;
import com.amazonaws.services.rekognition.model.*;
import com.amazonaws.util.IOUtils;
import com.mspr.API.POJO.Personne;
import org.postgresql.util.Base64;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.io.*;
import java.nio.ByteBuffer;
import java.util.List;
import java.util.Map;

import static com.mspr.API.Authentication.personne;

@Controller
@RequestMapping("/rekognition")
@SessionAttributes("rekognition")
public class Rekognition {
    private int status = 0;
    private boolean switchSatus = false;
    private Personne p;

    public Rekognition(){}

    private void changeStatus(int value) {
        if (!switchSatus) {
            status = value;
            switchSatus = true;
        }
    }

    @RequestMapping(method= RequestMethod.POST, produces = {"application/json"})
    @ResponseStatus(HttpStatus.OK)
    public @ResponseBody String run(@RequestBody Map<String,String> json) {
        String response = "";
        switchSatus = false;
        try {
            rekognition(json.get("imgSource"), json.get("identifiant"));
        } catch (Exception e) {
            e.printStackTrace();
            changeStatus(1);
        }

        switch (status) {
            case 0: response = "Problème majeur";
                break;
            case 1:  response = "Impossible d'accéder à la reconnaissance faciale";
                break;
            case 2:  response = "Le certificat amazon est obsolète/invalide";
                break;
            case 3:  response = "Aucun visage";
                break;
            case 4: response = "Erreur fichier photo";
                break;
            case 5: response = "Identifiant incorrect";
                break;
            case 6: response = "Le visage correspond";
                break;
            case 7: response = "Le visage ne correspond pas";
                break;
        }
        return response;
    }

    private void rekognition(String imgSource, String identifiant){
        AWSCredentials credentials;
        try {
            credentials = new ProfileCredentialsProvider().getCredentials();
        } catch (Exception e) {
            changeStatus(2);
            throw new AmazonClientException("Cannot load the credentials from the credential profiles file. "
                    + "Please make sure that your credentials file is at the correct "
                    + "location (/Users/userid/.aws/credentials), and is in valid format.", e);
        }

        AmazonRekognition rekognitionClient = AmazonRekognitionClientBuilder
                .standard()
                .withRegion(Regions.US_WEST_2)
                .withCredentials(new AWSStaticCredentialsProvider(credentials))
                .build();
        compareFace(rekognitionClient, imgSource, identifiant);
    }

    private void compareFace(AmazonRekognition rekognitionClient, String imgSource, String identifiant) {
        Image source = getImageUtil(imgSource);
        Image target = getImageUtil(getUserFace(identifiant));
        Float similarityThreshold = 70F;
        CompareFacesResult compareFacesResult = callCompareFaces(source,
                target,
                similarityThreshold,
                rekognitionClient);
        try {
            List<CompareFacesMatch> faceDetails = compareFacesResult.getFaceMatches();
            if (!faceDetails.isEmpty()) {
                System.out.println("Source image matches with target image");
                personne = p;
                changeStatus(6);
            } else {
                System.out.println("Source image doesn't matches with target image");
                changeStatus(7);
            }
            for (CompareFacesMatch match : faceDetails) {
                ComparedFace face = match.getFace();
                BoundingBox position = face.getBoundingBox();
                System.out.println("Face at " + position.getLeft().toString()
                        + " " + position.getTop()
                        + " matches with " + face.getConfidence().toString()
                        + "% confidence.\n");
            }
        } catch (Exception e) {
            e.printStackTrace();
            changeStatus(3);
        }
    }

    private CompareFacesResult callCompareFaces(Image sourceImage, Image targetImage,
                                                Float similarityThreshold, AmazonRekognition amazonRekognition) {
        CompareFacesResult result = null;
        CompareFacesRequest compareFacesRequest = new CompareFacesRequest()
                .withSourceImage(sourceImage)
                .withTargetImage(targetImage)
                .withSimilarityThreshold(similarityThreshold);
        try {
            result =  amazonRekognition.compareFaces(compareFacesRequest);
        }catch(Exception e){
            e.printStackTrace();
            changeStatus(3);
        }
        return result;
    }

    private Image getImageUtil(String base64) {
        byte[] data;
        ByteBuffer imageBytes = null;
        if (base64 != null) {
            data = Base64.decode(base64);
            try (OutputStream stream = new FileOutputStream("myimage.png")) {
                stream.write(data);
            } catch (IOException e) {
                e.printStackTrace();
                changeStatus(4);
            }
            try (InputStream inputStream = new BufferedInputStream(new FileInputStream("myimage.png"))) {
                imageBytes = ByteBuffer.wrap(IOUtils.toByteArray(inputStream));
            } catch (IOException e) {
                e.printStackTrace();
                changeStatus(4);
            }
        } else {
            changeStatus(5);
        }
        return new Image().withBytes(imageBytes);
    }

    private String getUserFace(String identifiant) {
        Personne personne = new Personne()  ;
        String b = null;
        b = personne.findPersonneByIdentifiant(identifiant).getVisage();
        return b;
    }
}