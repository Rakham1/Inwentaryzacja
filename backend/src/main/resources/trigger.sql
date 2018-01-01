CREATE TRIGGER trigger_name
  AFTER INSERT
  ON deposit_item
  FOR EACH ROW
  BEGIN
    UPDATE item
    SET stock = stock + NEW.amount
    WHERE id=NEW.item_id;
  END;
