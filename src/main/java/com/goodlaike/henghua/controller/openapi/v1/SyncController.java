package com.goodlaike.henghua.controller.openapi.v1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.goodlaike.business.core.controller.BaseRestController;
import com.goodlaike.henghua.RestResultWeb;
import com.goodlaike.henghua.entity.model.HenghuaSampleDetail;
import com.goodlaike.henghua.service.HenghuaService;

@RequestMapping("v1/sync")
@RestController
public class SyncController extends BaseRestController {

  @Autowired
  private HenghuaService henghuaService;

  @RequestMapping(value = "sampleDetail", method = RequestMethod.POST)
  protected ResponseEntity<?> syncSampleDetail(@RequestParam(name = "detailId", required = false) String detailId,
      @RequestParam(name = "desc_jpg", required = false) String desc_jpg, @RequestParam(name = "desc_png", required = false) String desc_png,
      @RequestParam(name = "desc_video", required = false) String desc_video, @RequestParam(name = "cardIds", required = false) String cardIds,
      @RequestParam(name = "nameCn", required = false) String nameCn, @RequestParam(name = "nameEn", required = false) String nameEn,
      @RequestParam(name = "level", required = false) String level, @RequestParam(name = "material", required = false) String material,
      @RequestParam(name = "style", required = false) String style, @RequestParam(name = "season", required = false) String season,
      @RequestParam(name = "gramWeight", required = false) String gramWeight, @RequestParam(name = "fabrics", required = false) String fabrics,
      @RequestParam(name = "tissue", required = false) String zuzhi, @RequestParam(name = "colorTypes", required = false) String colorTypes,
      @RequestParam(name = "materialTypes", required = false) String materialTypes,
      @RequestParam(name = "clearTypes", required = false) String clearTypes) {
    Assert.hasText(detailId, "the argument [detailId] must not be null or empty");
    HenghuaSampleDetail detail = new HenghuaSampleDetail();
    detail.setDetailId(detailId);
    detail.setCardIds(cardIds);
    detail.setDesc_jpg(desc_jpg);
    detail.setDesc_png(desc_png);
    detail.setDesc_video(desc_video);
    detail.setNameCn(nameCn);
    detail.setNameEn(nameEn);
    detail.setLevel(level);
    detail.setMaterial(materialTypes);
    detail.setStyle(style);
    detail.setSeason(season);
    detail.setGramWeight(gramWeight);
    detail.setFabrics(fabrics);
    detail.setZuzhi(zuzhi);
    detail.setColorTypes(colorTypes);
    detail.setMaterialTypes(materialTypes);
    detail.setClearTypes(clearTypes);
    try {
      this.henghuaService.syncHenghuaSampleDetail(detail);
      return ResponseEntity.ok().build();
    } catch (Exception e) {
      return super.serverError(RestResultWeb.SERVERERROR.rebuild(e.getMessage()));
    }
  }
}
