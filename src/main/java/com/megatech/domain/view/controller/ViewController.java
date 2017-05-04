package com.megatech.domain.view.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import com.megatech.domain.rest.model.Assets;
import com.megatech.domain.rest.service.AssetRestService;

@Controller
@RequestMapping("/view")
public class ViewController {

	@Autowired
	AssetRestService assetService;
	private final String baseUrl = "http://localhost:9090/MegatechAssets/rest/";

	//// Get Entire Assets....
	@RequestMapping("/list")
	public ModelAndView listAssets() {
		RestTemplate restTemplate = new RestTemplate();
		String url = baseUrl + "getAllAssets";
		List<?> assets = restTemplate.getForObject(url, List.class);
		return new ModelAndView("listassets", "assets", assets);
	}

	//// Get Entire Assets....
	@RequestMapping(value = "/getAllAssets", method = RequestMethod.GET, headers = "Accept=application/json")
	public String getAssets(Model model) {

		RestTemplate restTemplate = new RestTemplate();
		String url = baseUrl + "getAllAssets";
		List<?> listOfAssets = restTemplate.getForObject(url, List.class);
		model.addAttribute("asset", new Assets());
		model.addAttribute("listOfAssets", listOfAssets);
		return "assetsDetails";
	}

	@RequestMapping(value = "/addAsset", method = RequestMethod.POST, headers = "Accept=application/json")
	public String addAsset(@ModelAttribute("asset") Assets asset) {
		RestTemplate restTemplate = new RestTemplate();

		if (asset.getId() == 0) {
			// final String uri =
			// "http://localhost:9090/MegatechAssest/rest/addAsset";
			// restTemplate.postForObject(uri, asset, Assets.class);
			assetService.addAsset(asset);
		} else {
			// final String uri =
			// "http://localhost:9090/MegatechAssest/rest/updateAsset";
			// restTemplate.put(uri, asset);
			assetService.addAsset(asset);

		}

		return "redirect:/view/getAllAssets";
	}

	// Get SIngle Assets....
	@RequestMapping("/single/{id}")
	public ModelAndView dispAsset(@PathVariable("id") int id) {
		RestTemplate restTemplate = new RestTemplate();
		String url = baseUrl + "getAsset/{id}";
		Assets asset = restTemplate.getForObject(url, Assets.class, id);
		return new ModelAndView("displayasset", "asset", asset);
	}

	// Delete a Asset
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET, headers = "Accept=application/json")
	public String deleteAsset(@PathVariable("id") int id) {
		RestTemplate restTemplate = new RestTemplate();
		String url = baseUrl + "deleteAsset/{id}";
		restTemplate.delete(url, id);
		return "redirect:/view/getAllAssets";

	}

	@RequestMapping(value = "/update/{id}", method = RequestMethod.GET, headers = "Accept=application/json")
	public String updateAsset(@ModelAttribute("asset") Assets asset, @PathVariable("id") int id, Model model) {

		model.addAttribute("asset", this.assetService.getAsset(id));
		model.addAttribute("listOfAssets", this.assetService.getAllAssets());
		return "assetDetails";

	}

}