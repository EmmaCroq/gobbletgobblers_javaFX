module gobblets {
  requires javafx.fxml;
  requires transitive javafx.controls;
  
  requires transitive javafx.base;
  requires transitive javafx.graphics;

  exports gobblets;
  opens gobblets;
}