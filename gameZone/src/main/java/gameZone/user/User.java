package gameZone.user;

import gameZone.components.GlobalResources;

import javax.persistence.*;

@Entity
@Table(name="user")
public class User implements UserInterface {

    /* ************************************************* START INSTANCE VARIABLES ************************************************** */

    /**
     * {@code GlobalResources} {@code Component}. Grants the ability to use global variables and methods common to other {@code classes} in this Application
     */
    @Transient
    private final GlobalResources gValue = new GlobalResources();

    /**
     * ID for this {@code User}. Used for identification in the database
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id_db;

    /**
     * ID for this {@code User}. Used for identification in-game
     */
    private String id_app;

    /**
     * Total number of wins for this {@code User}
     */
    private Integer wins;

    /**
     * Total number of losses for this {@code User}
     */
    private Integer losses;

    /* ************************************************** END INSTANCE VARIABLES *************************************************** */

    /* **************************************************** START CONSTRUCTORS ***************************************************** */

    /**
     * Default constructor
     */
    public User() {

        this.setWins(0);
        this.setLosses(0);
        this.setIdApp(new String());
    }

    /* ***************************************************** END CONSTRUCTORS ****************************************************** */

    /* *************************************************** START GETTERS/SETTERS *************************************************** */

    @Override
    public Integer getIdDB() { return id_db; }
    @Override
    public void setIdDB(int id_db) { this.id_db =  id_db; }

    @Override
    public String getIdApp() { return id_app; }
    @Override
    public void setIdApp(String id_app) { this.id_app =  id_app; }

    @Override
    public Integer getWins() { return wins; }
    @Override
    public void setWins(int wins) { this.wins =  wins; }

    @Override
    public Integer getLosses() { return losses; }
    @Override
    public void setLosses(int losses) { this.losses =  losses; }

    /* **************************************************** END GETTERS/SETTERS **************************************************** */

    /* ***************************************************** START MISC METHODS **************************************************** */

    @Override
    public Double winLossRatio() { return (double)this.wins / this.losses; }

    /* ****************************************************** END MISC METHODS ***************************************************** */

    /* ********************************************************** END USER ********************************************************* */
}