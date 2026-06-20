SET SERVEROUTPUT ON

BEGIN

   FOR rec IN (
      SELECT c.customer_id, c.name, l.loan_id, l.interest_rate
      FROM customers c
      JOIN loans l ON c.customer_id = l.customer_id
      WHERE c.age > 60
   ) LOOP

      UPDATE loans
      SET interest_rate = interest_rate - 1
      WHERE loan_id = rec.loan_id;

      DBMS_OUTPUT.PUT_LINE(
         '1% discount applied for ' || rec.name
      );

   END LOOP;

   COMMIT;

END;
/