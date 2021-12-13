package com.ipiecoles.java.java230;

import com.ipiecoles.java.java230.model.Employe;
import com.ipiecoles.java.java230.model.Technicien;
import com.ipiecoles.java.java230.repository.EmployeRepository;
import com.ipiecoles.java.java230.repository.TechnicianRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class MyRunner implements CommandLineRunner {

    @Autowired
    private EmployeRepository employeRepository;

    @Autowired
    private TechnicianRepository technicienRepository;

    @Override
    public void run(String... strings) throws Exception {
        System.out.println(employeRepository.count());
//      Employe employe = employeRepository.findById(5L).get();
        Employe employe = employeRepository.findByMatricule("M00001");
//      employe.setSalaire(2500d);
//      employe = employeRepository.save(employe);
        System.out.println(employe.toString());


        List<Employe> employes = employeRepository.findByNomAndPrenom("gaillard", "victor");
        System.out.println(employes.toString());

        List<Employe> employes2 = employeRepository.findByNomIgnoreCase("poiRier");
        System.out.println(employes2.toString());

//        //pagination
//        PageRequest pageRequest = PageRequest.of(0, 5, Sort.Direction.ASC, "prenom");
//        Page<Employe> employeList2 = employeRepository.findByNomIgnoreCase("Andre", pageRequest);
//        System.out.println("All : " + employeList2.getTotalElements());
//        System.out.println("Total page number : " + employeList2.getTotalPages());
//        System.out.println("page size : " + employeList2.getSize());
//        System.out.println("sort by : " + employeList2.getSort().toString());
//        for (Employe employe2 : employeList2){
//            System.out.println(employe2.toString());
//        }
//        List<Employe> employeList3 = employeRepository.findByNomOrPrenomAllIgnoreCase("JULIEN");
//        for (Employe employe2 : employeList3){
//            System.out.println(employe2.toString());
//        }

        PageRequest pageRequest2 = PageRequest.of(0, 3, Sort.Direction.ASC, "matricule");
        List<Technicien> employes3 = technicienRepository.findAll();
        for(Employe employe4 : employes){
            System.out.println("Technicien"+ employe4.toString());
        }
    }
    public static void print(Object t) {
        System.out.println(t);
    }
}
