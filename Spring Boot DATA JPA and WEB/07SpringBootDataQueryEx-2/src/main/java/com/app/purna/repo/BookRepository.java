package com.app.purna.repo;



import java.util.List;

//import java.util.List;
//import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.app.purna.entity.Book;

public interface BookRepository extends JpaRepository<Book, Integer> {

	
	/***
	 * 
	 * Output findBy<Variable><condition>(DataType param);
	 * VariableName can be follwed same case are camelCase
	 */
	//SQL : select * from booktab where author=?
	//@Query("select b from Book b where b.author=?1")
	@Query("select b from Book b where b.author=:abc")
	List<Book> getBooksByAuthor(@Param("abc") String author);
	
	//SQL : select * from booktab where author like ? or bcost > ?
	@Query("select b from Book b where b.author Like ?1 Or b.bookCost > ?2 ")
	//@Query("select b from Book b where b.author Like :author Or b.bookCost > :bookCost ")
	List<Book> getBooksAuthorCost(String author, Double bookCost);
	
	//SQL : select * from booktab where bid in (? ? ?)
	//@Query("select b from Book b where b.bookId in (?1)")
	@Query("select b from Book b where b.bookId in (:bids)")
	List<Book> getBookIds(List<Integer> bids);
	
	
	
}
