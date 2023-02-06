INSERT INTO Category 
  (Title) 
VALUES
  ('Electronics'), 
  ('Clothes'), 
  ('Foods');

INSERT INTO Product 
  (Title, Category_Id, Price) 
VALUES
  ('Laptop', (SELECT Id FROM Category as C WHERE C.Title = 'Electronics'), 2500),
  ('Monitor', (SELECT Id FROM Category as C WHERE C.Title = 'Electronics'), 1000),
  ('Jeans', (SELECT Id FROM Category as C WHERE C.Title = 'Clothes'), 150),
  ('T-shirt', (SELECT Id FROM Category as C WHERE C.Title = 'Clothes'), 50),
  ('Burger', (SELECT Id FROM Category as C WHERE C.Title = 'Foods'), 15);





