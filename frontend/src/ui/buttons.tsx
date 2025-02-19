'use client'

import { deleteCustomer } from "../lib/actions";

export function DeleteCustomerButton({ customerId }: { customerId: string }) {
  return <button onClick={() => deleteCustomer(customerId)}>Xóa</button>;
}

export function FormToggleButton({ text, formId }) {
  function toggleForm() {
    document.getElementById(formId).style.display = "block";
  }

  return <button onClick={toggleForm}>{text}</button>
}