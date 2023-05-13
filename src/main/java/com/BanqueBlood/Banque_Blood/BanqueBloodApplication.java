package com.BanqueBlood.Banque_Blood;

import com.BanqueBlood.Banque_Blood.model.Admin;
import com.BanqueBlood.Banque_Blood.model.BanqueSang;
import com.BanqueBlood.Banque_Blood.model.GroupeSanguin;
import com.BanqueBlood.Banque_Blood.repository.AdminRepository;
import com.BanqueBlood.Banque_Blood.repository.BanqueSangRepository;
import com.BanqueBlood.Banque_Blood.repository.GroupeSanguinRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BanqueBloodApplication implements CommandLineRunner {


	public static void main(String[] args) {
		SpringApplication.run(BanqueBloodApplication.class, args);
	}

@Autowired
	AdminRepository adminRepository;
	@Autowired
	BanqueSangRepository banqueSangRepository;
	@Autowired
	GroupeSanguinRepository groupeSanguinRepository;
	@Override
	public void run(String... args) throws Exception {
//		Admin admin = new Admin( "fatou",  "kaloga", "bko",     76145034, "fatidiof@gmail.com", "fat", "azerty");
//		adminRepository.save(admin);
//		BanqueSang banqueSang = new BanqueSang("Luxembourg", "Hamdallaye", 777777, "luxembourg@gmail.com");
//		banqueSangRepository.save(banqueSang);
//		BanqueSang banqueSang1 = new BanqueSang("CNTS", "Quinzambougou", 7776677, "CNTS@gmail.com");
//		banqueSangRepository.save(banqueSang1);
		GroupeSanguin groupeSanguin = new GroupeSanguin("A+", "A+", "A+");
		groupeSanguinRepository.save(groupeSanguin);
		GroupeSanguin groupeSanguin1= new GroupeSanguin("A-", "A+", "A+");
		groupeSanguinRepository.save(groupeSanguin1);
		GroupeSanguin groupeSanguin2 = new GroupeSanguin("B+", "A+", "A+");
		groupeSanguinRepository.save(groupeSanguin2);




	}
}
