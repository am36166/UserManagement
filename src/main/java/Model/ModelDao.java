package Model;

import dao.User;
import java.util.List;

public class ModelDao {
   private String mc;
   private List<User> results;

   public ModelDao() {
   }

   public String getMc() {
      return this.mc;
   }

   public void setMc(String mc) {
      this.mc = mc;
   }

   public List<User> getResults() {
      return this.results;
   }

   public void setResults(List<User> results) {
      this.results = results;
   }
}