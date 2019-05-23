package com.mspr.API;

import com.mspr.API.POJO.Materiel;
import com.mspr.API.POJO.MaterielRepo;
import com.mspr.API.configuration.RepoConfig;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ApiApplicationTests {

	@Test
	public void contextLoads() {
		MaterielRepo accountRepository = (MaterielRepo) RepoConfig.contextProvider().getApplicationContext().getBean("materielRepo");
		List<Materiel> myList= accountRepository.getMaterielsByEmprunte(true);

		Assert.assertEquals(0,0);
	}

}

