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

public class BookGoogleAPI {

		@JsonProperty("title")
		private String title;
		
		private double price;
		public double getPrice() {
			return price;
		}
		public void setPrice(double price) {
			this.price = price;
		}

		@JsonProperty("authors")
		private List<String> authors = null;
		@JsonProperty("publisher")
		private String publisher;
		@JsonProperty("publishedDate")
		private String publishedDate;
		@JsonProperty("description")
		private String description;
		//ISBN_13 WORDT gebruikt
		@JsonProperty("industryIdentifiers")
		private String industryIdentifiers = null;
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
		private String panelizationSummary;
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
			String result;
			result=  "BookGoogleApi [title=" + title + ", authors="; 
		
				result+=	authors.isEmpty() ? "Unknown authors": authors.toString() ;
					
		/*	if(authors.isEmpty()) {
				result+="Unknown authors";
			}else {

				for(String a : authors)
				{
					result+=a + ", ";
				}
			}
			*/
					
				result+=	" publishedDate="
					+ publishedDate + ", description=" + description + 
					", price=" + price + ", ISBN=" +  industryIdentifiers +
					"]";
				
				return result;
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
		public String getIndustryIdentifiers() {
		return industryIdentifiers;
		}

		@JsonProperty("industryIdentifiers")
		public void setIndustryIdentifiers(String industryIdentifiers) {
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
		public String getPanelizationSummary() {
		return panelizationSummary;
		}

		@JsonProperty("panelizationSummary")
		public void setPanelizationSummary(String panelizationSummary) {
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
		//-----------------------------------logic.ImageLinks.java-----------------------------------



		@JsonInclude(JsonInclude.Include.NON_NULL)
		@JsonPropertyOrder({
		"smallThumbnail",
		"thumbnail"
		})
		static class ImageLinks {

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
		static class IndustryIdentifier {

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

}

