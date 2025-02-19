import styles from "./page.module.css";
import { FormToggleButton } from "@/ui/buttons";
import { addCustomerOrder } from "@/lib/actions";

export default async function Page({
  params,
}: {
  params: Promise<{ id: string }>
}) {
  const customerId = (await params).id;

  // Fetching customer
  const customerData = await fetch(`http://localhost:8080/api/customers/${customerId}`);
  const customer = await customerData.json();

  // Fetching orders from customer
  const orderData = await fetch(`http://localhost:8080/api/customers/${customerId}/orders`);
  const orders = await orderData.json();

  return (
    <>
      <h1>Thông tin khách hàng</h1>
      <ul>
        <li>Họ và tên: {customer.name}</li>
        <li>Địa chỉ: {customer.address}</li>
        <li>Số điện thoại: {customer.phone}</li>
        {(customer.vipStatus) ? <li>CÓ THẺ VIP (GIẢM 10%)</li> : <></>}
      </ul>
      <h2>Danh sách đơn hàng</h2>
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
      <form id="orderForm" className={styles.hidden} action={addCustomerOrder}>
        <div>
          <label htmlFor="customerId">Mã khách hàng:</label>
          <input type="text" name="customerId" id="customerId" value={customer.id} readOnly />
        </div>
        <div>
          <label htmlFor="total">Thành tiền:</label>
          <input type="number" name="total" id="total" min={0} required />
        </div>
        <input type="submit" value="Thêm" />
      </form>
    </>
  )
}