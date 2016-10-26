package ex01;

import javax.persistence.Entity;
import javax.persistence.Lob;
import javax.persistence.NamedQuery;

@Entity
@NamedQuery(name = CD01.FIND_ALL, query = "SELECT c FROM CD01 c")
public class CD01 extends Item01 {

	// ======================================
	// =             Constants              =
	// ======================================

	public static final String FIND_ALL = "CD01.findAllCDs";

	// ======================================
	// =             Attributes             =
	// ======================================

	@Lob
	private byte[] cover;
	private String musicCompany;
	private Integer numberOfCDs;
	private Float totalDuration;
	private String genre;

	// ======================================
	// =            Constructors            =
	// ======================================

	public CD01() {
	}

	public CD01(String title, Float price, String description) {
		this.title = title;
		this.price = price;
		this.description = description;
	}

	// ======================================
	// =          Getters & Setters         =
	// ======================================

	public byte[] getCover() {
		return cover;
	}

	public void setCover(byte[] cover) {
		this.cover = cover;
	}

	public String getMusicCompany() {
		return musicCompany;
	}

	public void setMusicCompany(String musicCompany) {
		this.musicCompany = musicCompany;
	}

	public Integer getNumberOfCDs() {
		return numberOfCDs;
	}

	public void setNumberOfCDs(Integer numberOfCDs) {
		this.numberOfCDs = numberOfCDs;
	}

	public Float getTotalDuration() {
		return totalDuration;
	}

	public void setTotalDuration(Float totalDuration) {
		this.totalDuration = totalDuration;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}
}
