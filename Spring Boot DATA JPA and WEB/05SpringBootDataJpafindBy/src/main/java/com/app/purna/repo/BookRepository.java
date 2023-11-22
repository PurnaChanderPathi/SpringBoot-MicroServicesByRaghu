package com.app.purna.repo;

import java.util.List;
import java.util.Optional;

//import java.util.List;
//import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.purna.entity.Book;

public interface BookRepository extends JpaRepository<Book, Integer> {

	
	/***
	 * 
	 * Output findBy<Variable><condition>(DataType param);
	 * VariableName can be follwed same case are camelCase
	 */
	
	//SQL: SELECT * FROM BOOK WHERE AUTHOR = ?
	//Optional<Book> findByAuthor(String author); // returns single row
//	List<Book> findByAuthor(String author); // returns multiple row
//	List<Book> findByauthorIs(String author);
//	List<Book> findByAuthorEquals(String author);
	
	//SQL : SELECT * FROM BOOK WHERE BOOKTYPE=?
	
	//List<Book> findByBookType(String bookType); // returns multiple row
	
	//findBy --> Select + where = !=, > < null, and or...
	//SQL: select * from book where bookCost<=?
	//List<Book> findByBookCostLessThanEqual(Double bookCost);
	//select * from book where bookId!=?
	//List<Book> findByBookIdNot(Double bookCost);
	
	//select * from book where bookCost<=?
	//List<Book> findByBookCostEqual(Double bookCost);
	
	//select * from book where bookCost>?
	//List<Book> findByBookCostGreaterThan(Double bookCost);
	
	//select * from book where author is null
	//List<Book> findByauthorIsNull();
	
	//select * from book where author is not null
	//List<Book> findByauthorIsNotNull();
	
	//-----------------Like Operator--------------
	//SQL : Select * from book where author like ?
	//List<Book> findByAuthorLike(String expression);
	
	//SQL : Select * from book where author like 'input%' ?
	//List<Book> findByAuthorStartingWith(String input);
		
	//SQL : Select * from book where author like '%input' ?
	//List<Book> findByAuthorEndingWith(String input);
	
	//SQL : Select * from book where author like '%input%' ?
	//List<Book> findByAuthorContaining(String input);
	
	//----------------------AND / OR --------------------
	
	//SQL select * from book where bookId <= ? or booktype like ?
	//List<Book> findByBookIdLessThanEqualOrBookTypeLike(Integer bookId, String input);
	
	//SQL select * from book where bookCost != ? and author not like ?
	//List<Book> findByBookCostGreaterThanAndAuthorNotLike(Double bookCost, String input);
	
	//SQl : select * from where cost > ? and author is not null or booktype like ?
 List<Book> findByBookCostGreaterThanAndAuthorIsNotNullOrBookTypeLike(Double bookCost,String bookType);
	
	List<Book> findByBookCostGreaterThanAndAuthorNotNull(Double bookCost);
	
 //   List<Book> findByAuthorNotNullAndAu(String author,Double bookCost);
	
	//---------------------single row---------------
	Optional<Book> findByBookId(Integer id);
	
	
}
