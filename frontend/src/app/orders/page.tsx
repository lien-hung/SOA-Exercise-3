import styles from '@/ui/layout.module.css';
import { FormToggleButton } from '@/ui/buttons';
import { addOrder } from '@/lib/actions';

export default async function Page() {
  const orderData = await fetch('http://localhost:8080/api/orders/');
  const orders = await orderData.json();

  return (
    <>
      <h1>Danh sách hóa đơn</h1>
      {orders.length === 0
        ? <p>Chưa có đơn hàng nào.</p>
        : <ul>
            {orders.map((order) => {
              return (
                <li key={order.id}>Mã hóa đơn: {order.id}, ngày lập {order.date}, thành tiền {order.total}</li>
              )
            })}
          </ul>}
      <FormToggleButton text={"Thêm hóa đơn"} formId={"orderForm"} />
      <form id="orderForm" className={styles.hidden} action={addOrder}>
        <div>
          <label htmlFor="total">Thành tiền:</label>
          <input type="number" name="total" id="total" min={0} required />
        </div>
        <input type="submit" value="Thêm" />
      </form>
    </>
  );
}