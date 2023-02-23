package org.example.web;

import jakarta.validation.Valid;
import org.example.domain.entities.Company;
import org.example.domain.models.CompanyAddModel;
import org.example.repositories.CompanyRepository;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/companies")
public class CompanyController {

    private final CompanyRepository companyRepository;

    public CompanyController(CompanyRepository companyRepository) {
        this.companyRepository = companyRepository;
    }

    @GetMapping("/add")
    public String getAddPage() {
        return "company-add";
    }

    @PatchMapping("/all")
    public ModelAndView patchCompany(@Valid @ModelAttribute(name = "companyAddModel")CompanyAddModel companyAddModel,
                                     BindingResult bindingResult,
                                     ModelAndView modelAndView) {
        if (bindingResult.hasErrors()) {
            modelAndView.setViewName("company-add");
            return modelAndView.addObject("companyAddModel",companyAddModel);
        }
        this.companyRepository.saveAndFlush(companyAddModel.toCompany());
        modelAndView.setViewName("company-all");

        return modelAndView;
    }

    @GetMapping("/all")
    public String getAllCompanyPages() {
        return "company-all";
    }

    @ModelAttribute(name = "initCompanyAddModel")
    public CompanyAddModel companyAddModel() {
        return new CompanyAddModel();
    }

    @ModelAttribute(name = "allCompanies")
    public List<Company> initCompanyAddModel() {
        return this.companyRepository.findAll();
    }
}
