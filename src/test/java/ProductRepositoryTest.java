
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.netology.domaine.PurchaseItem;
import ru.netology.repository.ProductRepository;

public class ProductRepositoryTest {

    PurchaseItem item1 = new PurchaseItem(11, 1, "Хлеб", 40, 10);
    PurchaseItem item2 = new PurchaseItem(12, 10, "Булка", 7, 81);
    PurchaseItem item3 = new PurchaseItem(13, 111, "Кортошка", 15, 8);
    PurchaseItem item4 = new PurchaseItem(14, 12, "Хлеб", 33, 7);

    @Test
    public void test() {
        ProductRepository repo = new ProductRepository();
        repo.save(item1);
        repo.save(item2);
        repo.save(item3);
        repo.save(item4);
        repo.removeById(item2.getId());

        PurchaseItem[] expected = {item1, item3, item4};
        PurchaseItem[] actual = repo.getItems();

        Assertions.assertArrayEquals(expected, actual);

    }


}
