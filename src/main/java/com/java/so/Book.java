package com.java.so;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.*;

@SuppressWarnings("serial")
@Entity
public class Book implements Serializable {

	@Id
	//@GeneratedValue(strategy=GenerationType.IDENTITY)
	//private long id;
	private String title;
	private Date date;
	@OneToMany(mappedBy="book",cascade=CascadeType.ALL)
	private List<Page> pages= new ArrayList<Page>();
	
	@JoinTable(
	        name = "rel_books_auths",
	        joinColumns = @JoinColumn(name = "FK_BOOK", nullable = false),
	        inverseJoinColumns = @JoinColumn(name="FK_AUTHOR", nullable = false)
	)
	@ManyToMany(cascade=CascadeType.ALL)
	private List<Author> author = new ArrayList<Author>();
	

	public Book(String title, Date date) {
		super();
		this.title = title;
		this.date = date;
	}
	
	public Book(String title) {
		super();
		this.title = title;
	}
	
	public Book() {
		super();
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((title == null) ? 0 : title.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Book other = (Book) obj;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		return true;
	}
	
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public void addPage(Page p) {
		pages.add(p);
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}

	public List<Page> getPages() {
		return pages;
	}

	public void setPages(List<Page> pages) {
		this.pages = pages;
	}
	public void addAuthor(Author a){
		author.add(a);
	}
	public List<Author> getAuthor() {
		return author;
	}

	public void setAuthor(List<Author> author) {
		this.author = author;
	}
	
	

	
}
