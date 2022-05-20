package project.sportsequipmentmanagementsystem;

public class PersistenceFactory {
    private static PersistenceHandler persistenceHandler;

    public void setConnection(PersistenceHandler persistenceHandler){
        PersistenceFactory.persistenceHandler = persistenceHandler;
    }

    public PersistenceHandler getConnection(){
        return persistenceHandler;
    }
}
