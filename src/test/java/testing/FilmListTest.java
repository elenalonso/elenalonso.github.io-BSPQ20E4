package testing;

import static org.junit.Assert.*;

import java.util.ArrayList;

import junit.framework.JUnit4TestAdapter;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import easyFilminData.Film;
import easyFilminData.FilmList;

public class FilmListTest {
	
	private String listName;
	private Film film1;
	private Film film2;
	private static Film film3;
	private static Film film4;
	private static FilmList list1;
	private FilmList list2;
	private static FilmList list3;
	
	
	public static junit.framework.Test suite() {
		return new JUnit4TestAdapter(FilmListTest.class);
		}

	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception{
		film3 = new Film();
		film3.setTitle("Attack");
		film4 = new Film();
		film4.setTitle("Counter");
		list1 = new FilmList("Favourite films");
		list3 = new FilmList("Favourite films");
		ArrayList<Film> films = new ArrayList<Film>();
		films.add(film3);
		list3.setFilmList(films);
		films.add(film4);
		list1.setFilmList(films);
	}
	@Before
	public void setUp() throws Exception {
		listName = "Favourite films";
		film1 = new Film();
		film1.setTitle("Attack");
		film2 = new Film();
		film2.setTitle("Counter");
		list2 = new FilmList(listName);
	}

	@Test
	public void testAddFilm() {
		list2.addFilm(film1);
		list2.addFilm(film2);
		assertEquals(list1, list2);
	}
	
	@Test
	public void testRemoveFilm() {
		list2.addFilm(film1);
		list2.addFilm(film2);
		list2.removeFilm("Counter");
		assertEquals(list3, list2);
	}
	
	@Test
	public void testSortFilmList() {
		list2.addFilm(film2);
		list2.addFilm(film1);
		list2.sortFilmList();
		assertEquals(list1, list2);
	}

}
