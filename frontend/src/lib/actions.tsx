'use server'

export async function deleteCustomer(id: string) {
  const response = await fetch(`http://localhost:8080/api/customers/${id}`, {
    method: "DELETE"
  });
  if (response.ok) {
    console.log("Xoá khách hàng thành công.");
  }
}

export async function addCustomer(formData: FormData) {
  const name = formData.get("name");
  const address = formData.get("address");
  const phone = formData.get("phone");
  const isVip = formData.get("isVip");

  const response = await fetch('http://localhost:8080/api/customers/', {
    method: "POST",
    headers: {
      'Accept': 'application/json',
      'Content-Type': 'application/json'
    },
    body: JSON.stringify({
      name: name,
      address: address,
      phone: phone,
      vipStatus: isVip != null
    })
  });
  if (response.ok) {
    console.log("Thêm khách hàng thành công.");
  }
}

export async function addOrder(formData: FormData) {
  const total = formData.get("total");

  const response = await fetch('http://localhost:8080/api/orders/', {
    method: "POST",
    headers: {
      'Accept': 'application/json',
      'Content-Type': 'application/json'
    },
    body: JSON.stringify({
      customerId: "",
      date: new Date().toJSON(),
      total: total
    })
  });

  if (response.ok) {
    console.log("Thêm hóa đơn thành công.");
  }
}

export async function addCustomerOrder(formData: FormData) {
  const customerId = formData.get("customerId");
  const total = formData.get("total");

  const response = await fetch('http://localhost:8080/api/orders/', {
    method: "POST",
    headers: {
      'Accept': 'application/json',
      'Content-Type': 'application/json'
    },
    body: JSON.stringify({
      customerId: customerId,
      date: new Date().toJSON(),
      total: total
    })
  });

  if (response.ok) {
    console.log("Thêm hóa đơn thành công.");
  }
}