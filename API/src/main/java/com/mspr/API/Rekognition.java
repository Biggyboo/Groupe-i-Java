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

@Controller
@RequestMapping("/rekognition")
@SessionAttributes("rekognition")
public class Rekognition {
    public Rekognition(){}

    @RequestMapping(method= RequestMethod.POST, produces = {"application/json"})
    @ResponseStatus(HttpStatus.OK)
    public @ResponseBody
    void run(@RequestBody Map<String,String> json) {
        try {
            rekognition(json.get("imgSource"), json.get("identifiant"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void rekognition(String imgSource, String identifiant){
        AWSCredentials credentials;
        try {
            credentials = new ProfileCredentialsProvider().getCredentials();
        } catch (Exception e) {
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
            } else {
                System.out.println("Source image doesn't matches with target image");
            }
            for (CompareFacesMatch match : faceDetails) {
                ComparedFace face = match.getFace();
                BoundingBox position = face.getBoundingBox();
                System.out.println("Face at " + position.getLeft().toString()
                        + " " + position.getTop()
                        + " matches with " + face.getConfidence().toString()
                        + "% confidence.\n");
            }
        }catch(Exception e){
            e.printStackTrace();
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
        }
        return result;
    }

    private Image getImageUtil(String base64) {
        byte[] data = Base64.decode(base64);
        try (OutputStream stream = new FileOutputStream("myimage.png")) {
            stream.write(data);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        ByteBuffer imageBytes = null;
        try (InputStream inputStream = new BufferedInputStream(new FileInputStream("myimage.png"))) {
            imageBytes = ByteBuffer.wrap(IOUtils.toByteArray(inputStream));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new Image().withBytes(imageBytes);
    }

    public String getUserFace(String identifiant) {
        Personne personne = new Personne();
        String b = null;
        try {
            for(Personne p: personne.findPersonneByIdentifiant(identifiant)){
                b = p.getVisage();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return b;
    }
}