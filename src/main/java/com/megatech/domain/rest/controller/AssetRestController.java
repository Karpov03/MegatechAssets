package com.megatech.domain.rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.megatech.domain.rest.model.Assets;
import com.megatech.domain.rest.service.AssetRestService;

@RestController
@RequestMapping(value = "/rest")
public class AssetRestController {

	@Autowired
	AssetRestService assetService;

	// @RequestMapping(value = "/getAllAssets", method = RequestMethod.GET,
	// headers = "Accept=application/json")
	@GetMapping("/getAllAssets")
	public List<Assets> getAssets() {

		List<Assets> listOfAssets = assetService.getAllAssets();
		return listOfAssets;
	}

	// @RequestMapping(value = "/getAsset/{id}", method = RequestMethod.GET,
	// headers = "Accept=application/json")
	// public Assets getAssetById(@PathVariable("id") int id) {
	// return assetService.getAsset(id);
	// }

	// @RequestMapping(value = "/getAsset/{id}", method = RequestMethod.GET,
	// produces = MediaType.APPLICATION_JSON_VALUE)
	@GetMapping("/getAsset/{id}")
	public ResponseEntity<Assets> getAssetById(@PathVariable("id") int id) {

		Assets asset = assetService.getAsset(id);
		if (asset == null) {
			return new ResponseEntity<Assets>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Assets>(asset, HttpStatus.OK);
	}

	// @RequestMapping(value = "/addAsset", method = RequestMethod.POST,
	// headers = "Accept=application/json")
	@PostMapping(value = "/addAsset")
	public void addAsset(@RequestBody Assets asset) {
		assetService.addAsset(asset);

	}

	// @RequestMapping(value = "/updateAsset", method = RequestMethod.PUT,
	// headers = "Accept=application/json")
	@PutMapping(value = "/updateAsset")
	public void updateAsset(@RequestBody Assets asset) {
		assetService.updateAssets(asset);
	}

	// update by Id
	@RequestMapping(value = "/update/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Assets> updateAssetbyId(@RequestBody Assets asset) {
		assetService.updateAssets1(asset);
		return new ResponseEntity<Assets>(asset, HttpStatus.OK);
	}

	// @RequestMapping(value = "/deleteAsset/{id}", method =
	// RequestMethod.DELETE, headers = "Accept=application/json")
	@DeleteMapping(value = "/deleteAsset/{id}")
	public ResponseEntity<Assets> deleteAsset(@PathVariable("id") int id) {
		assetService.deleteAssets(id);
		return new ResponseEntity<Assets>(HttpStatus.OK);
	}
}
