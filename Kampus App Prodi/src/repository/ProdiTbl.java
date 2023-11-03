package repository;

import model.Prodi;

public class ProdiTbl { 
    private Database db;
    
        public ProdiTbl(Database db) {
            this.db = db;
        }

        public void addProdi(Prodi prodi){
            db.tables.dataProdi.add(prodi);
            db.commit();
        }

        public void delete(String idProdi) {
            for(int i = 0; i < db.tables.dataProdi.size(); i++) {
                if(db.tables.dataProdi.get(i).getIdProdi().equals(idProdi)) {
                    db.tables.dataProdi.remove(i);
                    break;
                }
            }
            db.commit();
        }

        public Prodi getProdiById(String idProdi){
            for (Prodi prodi : db.tables.dataProdi){
                if (prodi.getIdProdi().equals(idProdi)){
                    return prodi;
                }
            }
            return null;
        }
    }   


