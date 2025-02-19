import Link from "next/link";
import styles from '@/ui/layout.module.css';
import { addCustomer } from "@/lib/actions";
import { DeleteCustomerButton, FormToggleButton } from "@/ui/buttons";

export default async function Page() {
  const data = await fetch('http://localhost:8080/api/customers/');
  const customers = await data.json();
  return (
    <>
      <h1>Danh sách khách hàng</h1>
      {customers.length === 0
        ? <p>Chưa có khách hàng nào.</p>
        : <ul>
            {customers.map((customer) => {
              return <li key={customer.id}>
                <Link href={`/customers/${customer.id}`}>{customer.name}</Link>
                <DeleteCustomerButton customerId={customer.id} />
              </li>
            })}
          </ul>}
      <FormToggleButton text={"Thêm khách hàng"} formId={"customerForm"} />
      <form id="customerForm" className={styles.hidden} action={addCustomer}>
        <fieldset>
          <legend>Thông tin khách hàng</legend>
          <div>
            <label htmlFor="name">Họ và tên:</label>
            <input type="text" name="name" id="name" required />
          </div>
          <div>
            <label htmlFor="address">Địa chỉ:</label>
            <input type="text" name="address" id="address" required />
          </div>
          <div>
            <label htmlFor="phone">Số điện thoại:</label>
            <input type="text" name="phone" id="phone" required />
          </div>
          <div>
            <label htmlFor="isVip">Có thẻ VIP:</label>
            <input type="checkbox" name="isVip" id="isVip" />
          </div>
          <input type="submit" value="Thêm" />
        </fieldset>
      </form>
    </>
  )
}