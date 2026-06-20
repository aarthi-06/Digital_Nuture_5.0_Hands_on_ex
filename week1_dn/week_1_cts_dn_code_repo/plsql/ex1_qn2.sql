SET SERVEROUTPUT ON

BEGIN

   FOR rec IN (
      SELECT customer_id, name, balance
      FROM customers
      WHERE balance > 10000
   ) LOOP

      UPDATE customers
      SET isvip = 'TRUE'
      WHERE customer_id = rec.customer_id;

      DBMS_OUTPUT.PUT_LINE(
         rec.name || ' promoted to VIP'
      );

   END LOOP;

   COMMIT;

END;
/