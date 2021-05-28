package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.management.Query;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Controller
public class aa {
    @Autowired(required = false)
    MieszkanieRepository mieszkaniaRepository;

    @RequestMapping("/")

    public ModelAndView home() {

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("home");

        return modelAndView;
    }


    @RequestMapping("/mieszkania")
    public ModelAndView mieszkania() {
        ModelAndView modelAndView = new ModelAndView();
        Mieszkanie miszkanie = new Mieszkanie();
        List<Mieszkanie> a = mieszkaniaRepository.findAll();
        modelAndView.addObject(a);
        modelAndView.addObject(miszkanie);

        modelAndView.setViewName("/mieszkania");
        return modelAndView;


    }

    @PostMapping("/mieszkania")
    public ModelAndView mieszkaniFiltr(@ModelAttribute("mieszkanie") Mieszkanie mieszkanie) {
        List<Mieszkanie> a = mieszkaniaRepository.findAll();
        List<Mieszkanie> poFiltrze = new ArrayList<Mieszkanie>();
        if (mieszkanie.getBalkon() != null) {
            a = a.stream().filter(e -> e.getBalkon() == mieszkanie.getBalkon())
                    .collect(Collectors.toList());
        }
        if (mieszkanie.getKlimatyzacja() != null) {
            a = a.stream().filter(e -> e.getKlimatyzacja().equals(mieszkanie.getKlimatyzacja()))
                    .collect(Collectors.toList());
        }
        if (!mieszkanie.getKraj().isEmpty()) {
            a = a.stream().filter(e -> e.getKraj().equals(mieszkanie.getKraj()))
                    .collect(Collectors.toList());
        }
        if (!mieszkanie.getMiasto().isEmpty()){
            a = a.stream().filter(e -> e.getMiasto().equals(mieszkanie.getMiasto()))
                    .collect(Collectors.toList());
        }
        if(!mieszkanie.getOgrzewanie().isEmpty())
        {
            a=a.stream().filter(e->e.getOgrzewanie().equals(mieszkanie.getOgrzewanie()))
                    .collect(Collectors.toList());

        }
        if(mieszkanie.getPokoje()!=null) {
            a = a.stream().filter(e -> e.getPokoje().equals(mieszkanie.getPokoje()))
                    .collect(Collectors.toList());
        }
        if(!mieszkanie.getRodzaj().isEmpty())
        {
            a=a.stream().filter(e->e.getRodzaj().equals(mieszkanie.getRodzaj()))
                    .collect(Collectors.toList());

        }
        if(mieszkanie.getRok()!=null)
        {
            a=a.stream().filter(e->e.getRok().equals(mieszkanie.getRok()))
                    .collect(Collectors.toList());
        }
        if(!mieszkanie.getStan().isEmpty())
        {
            a=a.stream().filter(e->e.getStan().equals(mieszkanie.getStan()))
                    .collect(Collectors.toList());
        }
        if(mieszkanie.getOd()!=null)
        {
            a=a.stream().filter(e->e.getCena() >= mieszkanie.getOd() )
                    .collect(Collectors.toList());
        }
        if(mieszkanie.getDo()!=null)
        {
            a=a.stream().filter(e->e.getCena()<=mieszkanie.getDo())
                    .collect(Collectors.toList());
        }
        if(mieszkanie.getMetrazOd()!=null)
        {
            a=a.stream().filter(e->e.getMetraz()>=mieszkanie.getMetrazOd())
                    .collect(Collectors.toList());
        }
        if(mieszkanie.getMetrazDo()!=null)
        {
            a=a.stream().filter(e->e.getMetraz()<=mieszkanie.getMetrazDo())
                    .collect(Collectors.toList());
        }

        ModelAndView modelAndView= new ModelAndView();
        modelAndView.addObject("mieszkanieList",a);
        return modelAndView;

    }
}



