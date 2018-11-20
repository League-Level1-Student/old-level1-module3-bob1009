

public class Netflixchill {
public static void main(String[] args) {
	Movie mov = new Movie("Avengers", 57);
	Movie avengers=new Movie("Avengers",57 );
	Movie BatmanvSuperman=new Movie("Batman v Superman", 2);
	Movie gaurdiansofthegalaxy=new Movie("gaurdians of the galaxy", 100);
	Movie Ironman=new Movie("Iron man", 86);
	Movie batman=new Movie("batman 1", 74);
	Movie justiceleague=new Movie("justice league",19);
	 String price=mov.getTicketPrice();
System.out.println(price);
NetflixQueue net=new NetflixQueue();
net.addMovie(avengers);
net.addMovie(BatmanvSuperman);
net.addMovie(gaurdiansofthegalaxy);
net.addMovie(Ironman);
net.addMovie(batman);
net.addMovie(justiceleague);
net.printMovies();
System.out.println("the best movie is...... " +gaurdiansofthegalaxy+ "!!!!!!!!!!!!!");
System.out.println("the second best movie is....... "+Ironman+ "!!!!!!!!!!!!!!");

}
} 
