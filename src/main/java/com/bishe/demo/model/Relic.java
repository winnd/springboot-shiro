package com.bishe.demo.model;

import java.io.File;
import java.util.Date;
import java.util.List;

public class Relic {
    private Integer id;

    private String name;

    private String picUrl;

    private String code;

    private Integer relicType;

    private String amount;

    private String level;

    private String size;

    private Double weight;

    private String attritionRate;

    private String application;

    private String craft;

    private String material;

    private String shape;

    private String feature;

    private String culturalConnotation;

    private String requiredTech;

    private String area;

    private String age;

    private Integer createBy;

    private Date createTime;

    private Integer updateBy;

    private Date updateTime;

    private String introduction;

    private Integer protectValue;

    private Integer cultureValue;

    private String dynasty;

    private String transformedUrn;

    private String bucketKey;

    private String modelName;

    private String urn;

    private List<RelicImage> relicImages;

    private File coverImg;                          // 上传用, 封面

    private File imgList;                           // 上传用, 其他图片

    public Relic(Integer id, String name, String picUrl, String code, Integer relicType, String amount, String level, String size, Double weight, String attritionRate, String application, String craft, String material, String shape, String feature, String culturalConnotation, String requiredTech, String area, String age, Integer createBy, Date createTime, Integer updateBy, Date updateTime, String introduction, Integer protectValue, Integer cultureValue, String dynasty, String transformedUrn, String bucketKey, String modelName, String urn) {
        this.id = id;
        this.name = name;
        this.picUrl = picUrl;
        this.code = code;
        this.relicType = relicType;
        this.amount = amount;
        this.level = level;
        this.size = size;
        this.weight = weight;
        this.attritionRate = attritionRate;
        this.application = application;
        this.craft = craft;
        this.material = material;
        this.shape = shape;
        this.feature = feature;
        this.culturalConnotation = culturalConnotation;
        this.requiredTech = requiredTech;
        this.area = area;
        this.age = age;
        this.createBy = createBy;
        this.createTime = createTime;
        this.updateBy = updateBy;
        this.updateTime = updateTime;
        this.introduction = introduction;
        this.protectValue = protectValue;
        this.cultureValue = cultureValue;
        this.dynasty = dynasty;
        this.transformedUrn = transformedUrn;
        this.bucketKey = bucketKey;
        this.modelName = modelName;
        this.urn = urn;
    }

    public Relic() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getPicUrl() {
        return picUrl;
    }

    public void setPicUrl(String picUrl) {
        this.picUrl = picUrl == null ? null : picUrl.trim();
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code == null ? null : code.trim();
    }

    public Integer getRelicType() {
        return relicType;
    }

    public void setRelicType(Integer relicType) {
        this.relicType = relicType;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount == null ? null : amount.trim();
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level == null ? null : level.trim();
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size == null ? null : size.trim();
    }

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    public String getAttritionRate() {
        return attritionRate;
    }

    public void setAttritionRate(String attritionRate) {
        this.attritionRate = attritionRate == null ? null : attritionRate.trim();
    }

    public String getApplication() {
        return application;
    }

    public void setApplication(String application) {
        this.application = application == null ? null : application.trim();
    }

    public String getCraft() {
        return craft;
    }

    public void setCraft(String craft) {
        this.craft = craft == null ? null : craft.trim();
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material == null ? null : material.trim();
    }

    public String getShape() {
        return shape;
    }

    public void setShape(String shape) {
        this.shape = shape == null ? null : shape.trim();
    }

    public String getFeature() {
        return feature;
    }

    public void setFeature(String feature) {
        this.feature = feature == null ? null : feature.trim();
    }

    public String getCulturalConnotation() {
        return culturalConnotation;
    }

    public void setCulturalConnotation(String culturalConnotation) {
        this.culturalConnotation = culturalConnotation == null ? null : culturalConnotation.trim();
    }

    public String getRequiredTech() {
        return requiredTech;
    }

    public void setRequiredTech(String requiredTech) {
        this.requiredTech = requiredTech == null ? null : requiredTech.trim();
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area == null ? null : area.trim();
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age == null ? null : age.trim();
    }

    public Integer getCreateBy() {
        return createBy;
    }

    public void setCreateBy(Integer createBy) {
        this.createBy = createBy;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Integer getUpdateBy() {
        return updateBy;
    }

    public void setUpdateBy(Integer updateBy) {
        this.updateBy = updateBy;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction == null ? null : introduction.trim();
    }

    public Integer getProtectValue() {
        return protectValue;
    }

    public void setProtectValue(Integer protectValue) {
        this.protectValue = protectValue;
    }

    public Integer getCultureValue() {
        return cultureValue;
    }

    public void setCultureValue(Integer cultureValue) {
        this.cultureValue = cultureValue;
    }

    public String getDynasty() {
        return dynasty;
    }

    public void setDynasty(String dynasty) {
        this.dynasty = dynasty == null ? null : dynasty.trim();
    }

    public String getTransformedUrn() {
        return transformedUrn;
    }

    public void setTransformedUrn(String transformedUrn) {
        this.transformedUrn = transformedUrn == null ? null : transformedUrn.trim();
    }

    public String getBucketKey() {
        return bucketKey;
    }

    public void setBucketKey(String bucketKey) {
        this.bucketKey = bucketKey == null ? null : bucketKey.trim();
    }

    public String getModelName() {
        return modelName;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName == null ? null : modelName.trim();
    }

    public String getUrn() {
        return urn;
    }

    public void setUrn(String urn) {
        this.urn = urn == null ? null : urn.trim();
    }

    public List<RelicImage> getRelicImages() {
        return relicImages;
    }

    public void setRelicImages(List<RelicImage> relicImages) {
        this.relicImages = relicImages;
    }

    public File getCoverImg() {
        return coverImg;
    }

    public void setCoverImg(File coverImg) {
        this.coverImg = coverImg;
    }

    public File getImgList() {
        return imgList;
    }

    public void setImgList(File imgList) {
        this.imgList = imgList;
    }
}