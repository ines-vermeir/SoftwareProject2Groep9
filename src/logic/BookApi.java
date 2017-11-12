
package logic;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;


//-----------------------------------logic.BookApi.java-----------------------------------


@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
"kind",
"totalItems",
"items"
})

public class BookApi {

	
	
@JsonProperty("kind")
private String kind;
@JsonProperty("totalItems")
private Integer totalItems;
@JsonProperty("items")
private List<Item> items = null;
@JsonIgnore
private Map<String, Object> additionalProperties = new HashMap<String, Object>();




@JsonProperty("kind")
public String getKind() {
return kind;
}

@JsonProperty("kind")
public void setKind(String kind) {
this.kind = kind;
}

@JsonProperty("totalItems")
public Integer getTotalItems() {
return totalItems;
}

@JsonProperty("totalItems")
public void setTotalItems(Integer totalItems) {
this.totalItems = totalItems;
}

@JsonProperty("items")
public List<Item> getItems() {
return items;
}

@JsonProperty("items")
public void setItems(List<Item> items) {
this.items = items;
}

@JsonAnyGetter
public Map<String, Object> getAdditionalProperties() {
return this.additionalProperties;
}

@JsonAnySetter
public void setAdditionalProperty(String name, Object value) {
this.additionalProperties.put(name, value);
}

}



//-----------------------------------logic.AccessInfo.java-----------------------------------


@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
"country",
"viewability",
"embeddable",
"publicDomain",
"textToSpeechPermission",
"epub",
"pdf",
"webReaderLink",
"accessViewStatus",
"quoteSharingAllowed"
})
class AccessInfo {

@JsonProperty("country")
private String country;
@JsonProperty("viewability")
private String viewability;
@JsonProperty("embeddable")
private Boolean embeddable;
@JsonProperty("publicDomain")
private Boolean publicDomain;
@JsonProperty("textToSpeechPermission")
private String textToSpeechPermission;
@JsonProperty("epub")
private Epub epub;
@JsonProperty("pdf")
private Pdf pdf;
@JsonProperty("webReaderLink")
private String webReaderLink;
@JsonProperty("accessViewStatus")
private String accessViewStatus;
@JsonProperty("quoteSharingAllowed")
private Boolean quoteSharingAllowed;
@JsonIgnore
private Map<String, Object> additionalProperties = new HashMap<String, Object>();

@JsonProperty("country")
public String getCountry() {
return country;
}

@JsonProperty("country")
public void setCountry(String country) {
this.country = country;
}

@JsonProperty("viewability")
public String getViewability() {
return viewability;
}

@JsonProperty("viewability")
public void setViewability(String viewability) {
this.viewability = viewability;
}

@JsonProperty("embeddable")
public Boolean getEmbeddable() {
return embeddable;
}

@JsonProperty("embeddable")
public void setEmbeddable(Boolean embeddable) {
this.embeddable = embeddable;
}

@JsonProperty("publicDomain")
public Boolean getPublicDomain() {
return publicDomain;
}

@JsonProperty("publicDomain")
public void setPublicDomain(Boolean publicDomain) {
this.publicDomain = publicDomain;
}

@JsonProperty("textToSpeechPermission")
public String getTextToSpeechPermission() {
return textToSpeechPermission;
}

@JsonProperty("textToSpeechPermission")
public void setTextToSpeechPermission(String textToSpeechPermission) {
this.textToSpeechPermission = textToSpeechPermission;
}

@JsonProperty("epub")
public Epub getEpub() {
return epub;
}

@JsonProperty("epub")
public void setEpub(Epub epub) {
this.epub = epub;
}

@JsonProperty("pdf")
public Pdf getPdf() {
return pdf;
}

@JsonProperty("pdf")
public void setPdf(Pdf pdf) {
this.pdf = pdf;
}

@JsonProperty("webReaderLink")
public String getWebReaderLink() {
return webReaderLink;
}

@JsonProperty("webReaderLink")
public void setWebReaderLink(String webReaderLink) {
this.webReaderLink = webReaderLink;
}

@JsonProperty("accessViewStatus")
public String getAccessViewStatus() {
return accessViewStatus;
}

@JsonProperty("accessViewStatus")
public void setAccessViewStatus(String accessViewStatus) {
this.accessViewStatus = accessViewStatus;
}

@JsonProperty("quoteSharingAllowed")
public Boolean getQuoteSharingAllowed() {
return quoteSharingAllowed;
}

@JsonProperty("quoteSharingAllowed")
public void setQuoteSharingAllowed(Boolean quoteSharingAllowed) {
this.quoteSharingAllowed = quoteSharingAllowed;
}

@JsonAnyGetter
public Map<String, Object> getAdditionalProperties() {
return this.additionalProperties;
}

@JsonAnySetter
public void setAdditionalProperty(String name, Object value) {
this.additionalProperties.put(name, value);
}

}

//-----------------------------------logic.Epub.java-----------------------------------



@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
"isAvailable",
"acsTokenLink"
})
class Epub {

@JsonProperty("isAvailable")
private Boolean isAvailable;
@JsonProperty("acsTokenLink")
private String acsTokenLink;
@JsonIgnore
private Map<String, Object> additionalProperties = new HashMap<String, Object>();

@JsonProperty("isAvailable")
public Boolean getIsAvailable() {
return isAvailable;
}

@JsonProperty("isAvailable")
public void setIsAvailable(Boolean isAvailable) {
this.isAvailable = isAvailable;
}

@JsonProperty("acsTokenLink")
public String getAcsTokenLink() {
return acsTokenLink;
}

@JsonProperty("acsTokenLink")
public void setAcsTokenLink(String acsTokenLink) {
this.acsTokenLink = acsTokenLink;
}

@JsonAnyGetter
public Map<String, Object> getAdditionalProperties() {
return this.additionalProperties;
}

@JsonAnySetter
public void setAdditionalProperty(String name, Object value) {
this.additionalProperties.put(name, value);
}

}
//-----------------------------------logic.ImageLinks.java-----------------------------------



@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
"smallThumbnail",
"thumbnail"
})
 class ImageLinks {

@JsonProperty("smallThumbnail")
private String smallThumbnail;
@JsonProperty("thumbnail")
private String thumbnail;
@JsonIgnore
private Map<String, Object> additionalProperties = new HashMap<String, Object>();

@JsonProperty("smallThumbnail")
public String getSmallThumbnail() {
return smallThumbnail;
}

@JsonProperty("smallThumbnail")
public void setSmallThumbnail(String smallThumbnail) {
this.smallThumbnail = smallThumbnail;
}

@JsonProperty("thumbnail")
public String getThumbnail() {
return thumbnail;
}

@JsonProperty("thumbnail")
public void setThumbnail(String thumbnail) {
this.thumbnail = thumbnail;
}

@JsonAnyGetter
public Map<String, Object> getAdditionalProperties() {
return this.additionalProperties;
}

@JsonAnySetter
public void setAdditionalProperty(String name, Object value) {
this.additionalProperties.put(name, value);
}

}
//-----------------------------------logic.IndustryIdentifier.java-----------------------------------


@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
"type",
"identifier"
})
class IndustryIdentifier {

@JsonProperty("type")
private String type;
@JsonProperty("identifier")
private String identifier;
@JsonIgnore
private Map<String, Object> additionalProperties = new HashMap<String, Object>();

@JsonProperty("type")
public String getType() {
return type;
}

@JsonProperty("type")
public void setType(String type) {
this.type = type;
}

@JsonProperty("identifier")
public String getIdentifier() {
return identifier;
}

@JsonProperty("identifier")
public void setIdentifier(String identifier) {
this.identifier = identifier;
}

@JsonAnyGetter
public Map<String, Object> getAdditionalProperties() {
return this.additionalProperties;
}

@JsonAnySetter
public void setAdditionalProperty(String name, Object value) {
this.additionalProperties.put(name, value);
}

}
//-----------------------------------logic.Item.java-----------------------------------

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
"kind",
"id",
"etag",
"selfLink",
"volumeInfo",
"saleInfo",
"accessInfo",
"searchInfo"
})
 class Item {
	
	



@JsonProperty("kind")
private String kind;
@JsonProperty("id")
private String id;
@JsonProperty("etag")
private String etag;
@JsonProperty("selfLink")
private String selfLink;
@JsonProperty("volumeInfo")
private VolumeInfo volumeInfo;
@JsonProperty("saleInfo")
private SaleInfo saleInfo;
@JsonProperty("accessInfo")
private AccessInfo accessInfo;
@JsonProperty("searchInfo")
private SearchInfo searchInfo;
@JsonIgnore
private Map<String, Object> additionalProperties = new HashMap<String, Object>();



@JsonProperty("kind")
public String getKind() {
return kind;
}

@JsonProperty("kind")
public void setKind(String kind) {
this.kind = kind;
}

@JsonProperty("id")
public String getId() {
return id;
}

@JsonProperty("id")
public void setId(String id) {
this.id = id;
}

@JsonProperty("etag")
public String getEtag() {
return etag;
}

@JsonProperty("etag")
public void setEtag(String etag) {
this.etag = etag;
}

@JsonProperty("selfLink")
public String getSelfLink() {
return selfLink;
}

@JsonProperty("selfLink")
public void setSelfLink(String selfLink) {
this.selfLink = selfLink;
}

@JsonProperty("volumeInfo")
public VolumeInfo getVolumeInfo() {
return volumeInfo;
}

@JsonProperty("volumeInfo")
public void setVolumeInfo(VolumeInfo volumeInfo) {
this.volumeInfo = volumeInfo;
}

@JsonProperty("saleInfo")
public SaleInfo getSaleInfo() {
return saleInfo;
}

@JsonProperty("saleInfo")
public void setSaleInfo(SaleInfo saleInfo) {
this.saleInfo = saleInfo;
}

@JsonProperty("accessInfo")
public AccessInfo getAccessInfo() {
return accessInfo;
}

@JsonProperty("accessInfo")
public void setAccessInfo(AccessInfo accessInfo) {
this.accessInfo = accessInfo;
}

@JsonProperty("searchInfo")
public SearchInfo getSearchInfo() {
return searchInfo;
}

@JsonProperty("searchInfo")
public void setSearchInfo(SearchInfo searchInfo) {
this.searchInfo = searchInfo;
}

@JsonAnyGetter
public Map<String, Object> getAdditionalProperties() {
return this.additionalProperties;
}

@JsonAnySetter
public void setAdditionalProperty(String name, Object value) {
this.additionalProperties.put(name, value);
}

}
//-----------------------------------logic.ListPrice.java-----------------------------------



@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
"amount",
"currencyCode"
})
class ListPrice {
@JsonProperty("amount")
private Double amount;
@JsonProperty("currencyCode")
private String currencyCode;
@JsonIgnore
private Map<String, Object> additionalProperties = new HashMap<String, Object>();

@JsonProperty("amount")
public Double getAmount() {
return amount;
}

@JsonProperty("amount")
public void setAmount(Double amount) {
this.amount = amount;
}

@JsonProperty("currencyCode")
public String getCurrencyCode() {
return currencyCode;
}

@JsonProperty("currencyCode")
public void setCurrencyCode(String currencyCode) {
this.currencyCode = currencyCode;
}

@JsonAnyGetter
public Map<String, Object> getAdditionalProperties() {
return this.additionalProperties;
}

@JsonAnySetter
public void setAdditionalProperty(String name, Object value) {
this.additionalProperties.put(name, value);
}

}
//-----------------------------------logic.ListPrice_.java-----------------------------------



@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
"amountInMicros",
"currencyCode"
})
class ListPrice_ {

@JsonProperty("amountInMicros")
private Double amountInMicros;
@JsonProperty("currencyCode")
private String currencyCode;
@JsonIgnore
private Map<String, Object> additionalProperties = new HashMap<String, Object>();

@JsonProperty("amountInMicros")
public Double getAmountInMicros() {
return amountInMicros;
}

@JsonProperty("amountInMicros")
public void setAmountInMicros(Double amountInMicros) {
this.amountInMicros = amountInMicros;
}

@JsonProperty("currencyCode")
public String getCurrencyCode() {
return currencyCode;
}

@JsonProperty("currencyCode")
public void setCurrencyCode(String currencyCode) {
this.currencyCode = currencyCode;
}

@JsonAnyGetter
public Map<String, Object> getAdditionalProperties() {
return this.additionalProperties;
}

@JsonAnySetter
public void setAdditionalProperty(String name, Object value) {
this.additionalProperties.put(name, value);
}

}
//-----------------------------------logic.Offer.java-----------------------------------



@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
"finskyOfferType",
"listPrice",
"retailPrice"
})
class Offer {

@JsonProperty("finskyOfferType")
private Integer finskyOfferType;
@JsonProperty("listPrice")
private ListPrice_ listPrice;
@JsonProperty("retailPrice")
private RetailPrice_ retailPrice;
@JsonIgnore
private Map<String, Object> additionalProperties = new HashMap<String, Object>();

@JsonProperty("finskyOfferType")
public Integer getFinskyOfferType() {
return finskyOfferType;
}

@JsonProperty("finskyOfferType")
public void setFinskyOfferType(Integer finskyOfferType) {
this.finskyOfferType = finskyOfferType;
}

@JsonProperty("listPrice")
public ListPrice_ getListPrice() {
return listPrice;
}

@JsonProperty("listPrice")
public void setListPrice(ListPrice_ listPrice) {
this.listPrice = listPrice;
}

@JsonProperty("retailPrice")
public RetailPrice_ getRetailPrice() {
return retailPrice;
}

@JsonProperty("retailPrice")
public void setRetailPrice(RetailPrice_ retailPrice) {
this.retailPrice = retailPrice;
}

@JsonAnyGetter
public Map<String, Object> getAdditionalProperties() {
return this.additionalProperties;
}

@JsonAnySetter
public void setAdditionalProperty(String name, Object value) {
this.additionalProperties.put(name, value);
}

}
//-----------------------------------logic.PanelizationSummary.java-----------------------------------



@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
"containsEpubBubbles",
"containsImageBubbles"
})
class PanelizationSummary {

@JsonProperty("containsEpubBubbles")
private Boolean containsEpubBubbles;
@JsonProperty("containsImageBubbles")
private Boolean containsImageBubbles;
@JsonIgnore
private Map<String, Object> additionalProperties = new HashMap<String, Object>();

@JsonProperty("containsEpubBubbles")
public Boolean getContainsEpubBubbles() {
return containsEpubBubbles;
}

@JsonProperty("containsEpubBubbles")
public void setContainsEpubBubbles(Boolean containsEpubBubbles) {
this.containsEpubBubbles = containsEpubBubbles;
}

@JsonProperty("containsImageBubbles")
public Boolean getContainsImageBubbles() {
return containsImageBubbles;
}

@JsonProperty("containsImageBubbles")
public void setContainsImageBubbles(Boolean containsImageBubbles) {
this.containsImageBubbles = containsImageBubbles;
}

@JsonAnyGetter
public Map<String, Object> getAdditionalProperties() {
return this.additionalProperties;
}

@JsonAnySetter
public void setAdditionalProperty(String name, Object value) {
this.additionalProperties.put(name, value);
}

}
//-----------------------------------logic.Pdf.java-----------------------------------


@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
"isAvailable",
"acsTokenLink"
})
class Pdf {

@JsonProperty("isAvailable")
private Boolean isAvailable;
@JsonProperty("acsTokenLink")
private String acsTokenLink;
@JsonIgnore
private Map<String, Object> additionalProperties = new HashMap<String, Object>();

@JsonProperty("isAvailable")
public Boolean getIsAvailable() {
return isAvailable;
}

@JsonProperty("isAvailable")
public void setIsAvailable(Boolean isAvailable) {
this.isAvailable = isAvailable;
}

@JsonProperty("acsTokenLink")
public String getAcsTokenLink() {
return acsTokenLink;
}

@JsonProperty("acsTokenLink")
public void setAcsTokenLink(String acsTokenLink) {
this.acsTokenLink = acsTokenLink;
}

@JsonAnyGetter
public Map<String, Object> getAdditionalProperties() {
return this.additionalProperties;
}

@JsonAnySetter
public void setAdditionalProperty(String name, Object value) {
this.additionalProperties.put(name, value);
}

}
//-----------------------------------logic.ReadingModes.java-----------------------------------


@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
"text",
"image"
})
class ReadingModes {

@JsonProperty("text")
private Boolean text;
@JsonProperty("image")
private Boolean image;
@JsonIgnore
private Map<String, Object> additionalProperties = new HashMap<String, Object>();

@JsonProperty("text")
public Boolean getText() {
return text;
}

@JsonProperty("text")
public void setText(Boolean text) {
this.text = text;
}

@JsonProperty("image")
public Boolean getImage() {
return image;
}

@JsonProperty("image")
public void setImage(Boolean image) {
this.image = image;
}

@JsonAnyGetter
public Map<String, Object> getAdditionalProperties() {
return this.additionalProperties;
}

@JsonAnySetter
public void setAdditionalProperty(String name, Object value) {
this.additionalProperties.put(name, value);
}

}
//-----------------------------------logic.RetailPrice.java-----------------------------------


@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
"amount",
"currencyCode"
})
class RetailPrice {

@JsonProperty("amount")
private Double amount;
@JsonProperty("currencyCode")
private String currencyCode;
@JsonIgnore
private Map<String, Object> additionalProperties = new HashMap<String, Object>();

@JsonProperty("amount")
public Double getAmount() {
return amount;
}

@JsonProperty("amount")
public void setAmount(Double amount) {
this.amount = amount;
}

@JsonProperty("currencyCode")
public String getCurrencyCode() {
return currencyCode;
}

@JsonProperty("currencyCode")
public void setCurrencyCode(String currencyCode) {
this.currencyCode = currencyCode;
}

@JsonAnyGetter
public Map<String, Object> getAdditionalProperties() {
return this.additionalProperties;
}

@JsonAnySetter
public void setAdditionalProperty(String name, Object value) {
this.additionalProperties.put(name, value);
}

}
//-----------------------------------logic.RetailPrice_.java-----------------------------------



@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
"amountInMicros",
"currencyCode"
})
class RetailPrice_ {

@JsonProperty("amountInMicros")
private Double amountInMicros;
@JsonProperty("currencyCode")
private String currencyCode;
@JsonIgnore
private Map<String, Object> additionalProperties = new HashMap<String, Object>();

@JsonProperty("amountInMicros")
public Double getAmountInMicros() {
return amountInMicros;
}

@JsonProperty("amountInMicros")
public void setAmountInMicros(Double amountInMicros) {
this.amountInMicros = amountInMicros;
}

@JsonProperty("currencyCode")
public String getCurrencyCode() {
return currencyCode;
}

@JsonProperty("currencyCode")
public void setCurrencyCode(String currencyCode) {
this.currencyCode = currencyCode;
}

@JsonAnyGetter
public Map<String, Object> getAdditionalProperties() {
return this.additionalProperties;
}

@JsonAnySetter
public void setAdditionalProperty(String name, Object value) {
this.additionalProperties.put(name, value);
}

}
//-----------------------------------logic.SaleInfo.java-----------------------------------


@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
"country",
"saleability",
"isEbook",
"listPrice",
"retailPrice",
"buyLink",
"offers"
})
class SaleInfo {

@JsonProperty("country")
private String country;
@JsonProperty("saleability")
private String saleability;
@JsonProperty("isEbook")
private Boolean isEbook;
@JsonProperty("listPrice")
private ListPrice listPrice;
@JsonProperty("retailPrice")
private RetailPrice retailPrice;
@JsonProperty("buyLink")
private String buyLink;
@JsonProperty("offers")
private List<Offer> offers = null;
@JsonIgnore
private Map<String, Object> additionalProperties = new HashMap<String, Object>();

@JsonProperty("country")
public String getCountry() {
return country;
}

@JsonProperty("country")
public void setCountry(String country) {
this.country = country;
}

@JsonProperty("saleability")
public String getSaleability() {
return saleability;
}

@JsonProperty("saleability")
public void setSaleability(String saleability) {
this.saleability = saleability;
}

@JsonProperty("isEbook")
public Boolean getIsEbook() {
return isEbook;
}

@JsonProperty("isEbook")
public void setIsEbook(Boolean isEbook) {
this.isEbook = isEbook;
}

@JsonProperty("listPrice")
public ListPrice getListPrice() {
return listPrice;
}

@JsonProperty("listPrice")
public void setListPrice(ListPrice listPrice) {
this.listPrice = listPrice;
}

@JsonProperty("retailPrice")
public RetailPrice getRetailPrice() {
return retailPrice;
}

@JsonProperty("retailPrice")
public void setRetailPrice(RetailPrice retailPrice) {
this.retailPrice = retailPrice;
}

@JsonProperty("buyLink")
public String getBuyLink() {
return buyLink;
}

@JsonProperty("buyLink")
public void setBuyLink(String buyLink) {
this.buyLink = buyLink;
}

@JsonProperty("offers")
public List<Offer> getOffers() {
return offers;
}

@JsonProperty("offers")
public void setOffers(List<Offer> offers) {
this.offers = offers;
}

@JsonAnyGetter
public Map<String, Object> getAdditionalProperties() {
return this.additionalProperties;
}

@JsonAnySetter
public void setAdditionalProperty(String name, Object value) {
this.additionalProperties.put(name, value);
}

}
//-----------------------------------logic.SearchInfo.java-----------------------------------



@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
"textSnippet"
})
class SearchInfo {

@JsonProperty("textSnippet")
private String textSnippet;
@JsonIgnore
private Map<String, Object> additionalProperties = new HashMap<String, Object>();

@JsonProperty("textSnippet")
public String getTextSnippet() {
return textSnippet;
}

@JsonProperty("textSnippet")
public void setTextSnippet(String textSnippet) {
this.textSnippet = textSnippet;
}

@JsonAnyGetter
public Map<String, Object> getAdditionalProperties() {
return this.additionalProperties;
}

@JsonAnySetter
public void setAdditionalProperty(String name, Object value) {
this.additionalProperties.put(name, value);
}

}
//-----------------------------------logic.VolumeInfo.java-----------------------------------


@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
"title",
"authors",
"publisher",
"publishedDate",
"description",
"industryIdentifiers",
"readingModes",
"pageCount",
"printType",
"categories",
"averageRating",
"ratingsCount",
"maturityRating",
"allowAnonLogging",
"contentVersion",
"panelizationSummary",
"imageLinks",
"language",
"previewLink",
"infoLink",
"canonicalVolumeLink",
"subtitle"
})
class VolumeInfo {

@JsonProperty("title")
private String title;
@JsonProperty("authors")
private List<String> authors = null;
@JsonProperty("publisher")
private String publisher;
@JsonProperty("publishedDate")
private String publishedDate;
@JsonProperty("description")
private String description;
@JsonProperty("industryIdentifiers")
private List<IndustryIdentifier> industryIdentifiers = null;
@JsonProperty("readingModes")
private ReadingModes readingModes;
@JsonProperty("pageCount")
private Integer pageCount;
@JsonProperty("printType")
private String printType;
@JsonProperty("categories")
private List<String> categories = null;
@JsonProperty("averageRating")
private Double averageRating;
@JsonProperty("ratingsCount")
private Integer ratingsCount;
@JsonProperty("maturityRating")
private String maturityRating;
@JsonProperty("allowAnonLogging")
private Boolean allowAnonLogging;
@JsonProperty("contentVersion")
private String contentVersion;
@JsonProperty("panelizationSummary")
private PanelizationSummary panelizationSummary;
@JsonProperty("imageLinks")
private ImageLinks imageLinks;
@JsonProperty("language")
private String language;
@JsonProperty("previewLink")
private String previewLink;
@JsonProperty("infoLink")
private String infoLink;
@JsonProperty("canonicalVolumeLink")
private String canonicalVolumeLink;
@JsonProperty("subtitle")
private String subtitle;
@JsonIgnore
private Map<String, Object> additionalProperties = new HashMap<String, Object>();


@Override
public String toString() {
	return "VolumeInfo [title=" + title + ", authors=" + authors + ", publisher=" + publisher + ", publishedDate="
			+ publishedDate + ", description=" + description + ", pageCount=" + pageCount + ", categories=" + categories
			+ ", averageRating=" + averageRating + ", maturityRating=" + maturityRating + ", language=" + language
			+ ", infoLink=" + infoLink + "]";
}
@JsonProperty("title")
public String getTitle() {
return title;
}

@JsonProperty("title")
public void setTitle(String title) {
this.title = title;
}

@JsonProperty("authors")
public List<String> getAuthors() {
return authors;
}

@JsonProperty("authors")
public void setAuthors(List<String> authors) {
this.authors = authors;
}

@JsonProperty("publisher")
public String getPublisher() {
return publisher;
}

@JsonProperty("publisher")
public void setPublisher(String publisher) {
this.publisher = publisher;
}

@JsonProperty("publishedDate")
public String getPublishedDate() {
return publishedDate;
}

@JsonProperty("publishedDate")
public void setPublishedDate(String publishedDate) {
this.publishedDate = publishedDate;
}

@JsonProperty("description")
public String getDescription() {
return description;
}

@JsonProperty("description")
public void setDescription(String description) {
this.description = description;
}

@JsonProperty("industryIdentifiers")
public List<IndustryIdentifier> getIndustryIdentifiers() {
return industryIdentifiers;
}

@JsonProperty("industryIdentifiers")
public void setIndustryIdentifiers(List<IndustryIdentifier> industryIdentifiers) {
this.industryIdentifiers = industryIdentifiers;
}

@JsonProperty("readingModes")
public ReadingModes getReadingModes() {
return readingModes;
}

@JsonProperty("readingModes")
public void setReadingModes(ReadingModes readingModes) {
this.readingModes = readingModes;
}

@JsonProperty("pageCount")
public Integer getPageCount() {
return pageCount;
}

@JsonProperty("pageCount")
public void setPageCount(Integer pageCount) {
this.pageCount = pageCount;
}

@JsonProperty("printType")
public String getPrintType() {
return printType;
}

@JsonProperty("printType")
public void setPrintType(String printType) {
this.printType = printType;
}

@JsonProperty("categories")
public List<String> getCategories() {
return categories;
}

@JsonProperty("categories")
public void setCategories(List<String> categories) {
this.categories = categories;
}

@JsonProperty("averageRating")
public Double getAverageRating() {
return averageRating;
}

@JsonProperty("averageRating")
public void setAverageRating(Double averageRating) {
this.averageRating = averageRating;
}

@JsonProperty("ratingsCount")
public Integer getRatingsCount() {
return ratingsCount;
}

@JsonProperty("ratingsCount")
public void setRatingsCount(Integer ratingsCount) {
this.ratingsCount = ratingsCount;
}

@JsonProperty("maturityRating")
public String getMaturityRating() {
return maturityRating;
}

@JsonProperty("maturityRating")
public void setMaturityRating(String maturityRating) {
this.maturityRating = maturityRating;
}

@JsonProperty("allowAnonLogging")
public Boolean getAllowAnonLogging() {
return allowAnonLogging;
}

@JsonProperty("allowAnonLogging")
public void setAllowAnonLogging(Boolean allowAnonLogging) {
this.allowAnonLogging = allowAnonLogging;
}

@JsonProperty("contentVersion")
public String getContentVersion() {
return contentVersion;
}

@JsonProperty("contentVersion")
public void setContentVersion(String contentVersion) {
this.contentVersion = contentVersion;
}

@JsonProperty("panelizationSummary")
public PanelizationSummary getPanelizationSummary() {
return panelizationSummary;
}

@JsonProperty("panelizationSummary")
public void setPanelizationSummary(PanelizationSummary panelizationSummary) {
this.panelizationSummary = panelizationSummary;
}

@JsonProperty("imageLinks")
public ImageLinks getImageLinks() {
return imageLinks;
}

@JsonProperty("imageLinks")
public void setImageLinks(ImageLinks imageLinks) {
this.imageLinks = imageLinks;
}

@JsonProperty("language")
public String getLanguage() {
return language;
}

@JsonProperty("language")
public void setLanguage(String language) {
this.language = language;
}

@JsonProperty("previewLink")
public String getPreviewLink() {
return previewLink;
}

@JsonProperty("previewLink")
public void setPreviewLink(String previewLink) {
this.previewLink = previewLink;
}

@JsonProperty("infoLink")
public String getInfoLink() {
return infoLink;
}

@JsonProperty("infoLink")
public void setInfoLink(String infoLink) {
this.infoLink = infoLink;
}

@JsonProperty("canonicalVolumeLink")
public String getCanonicalVolumeLink() {
return canonicalVolumeLink;
}

@JsonProperty("canonicalVolumeLink")
public void setCanonicalVolumeLink(String canonicalVolumeLink) {
this.canonicalVolumeLink = canonicalVolumeLink;
}

@JsonProperty("subtitle")
public String getSubtitle() {
return subtitle;
}

@JsonProperty("subtitle")
public void setSubtitle(String subtitle) {
this.subtitle = subtitle;
}

@JsonAnyGetter
public Map<String, Object> getAdditionalProperties() {
return this.additionalProperties;
}

@JsonAnySetter
public void setAdditionalProperty(String name, Object value) {
this.additionalProperties.put(name, value);
}

}