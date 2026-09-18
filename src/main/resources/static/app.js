// 1. Fetch and display all accounts on page load
fetch('/account')
  .then(res => res.json())
  .then(accounts => {
    let output = "<tr><th>ID</th><th>Name</th><th>Phone</th><th>Actions</th></tr>";
    
    accounts.forEach(acc => {
      output += `
        <tr>
          <td>${acc.id}</td>
          <td>${acc.name}</td>
          <td>${acc.phoneNumber}</td>
          <td>
            <button onclick="updateAcc(${acc.id}, '${(acc.name || '').replace(/'/g, "\\'")}', '${(acc.phoneNumber || '').replace(/'/g, "\\'")}')">Update</button>
            <button onclick="del(${acc.id})">Delete</button>
          </td>
        </tr>
      `;
    });
    
    document.getElementById('accountTable').innerHTML = output;
  });

// 2. Add a new account
document.getElementById('addForm').onsubmit = (event) => {
  event.preventDefault();

  fetch('/account', {
    method: 'POST',
    headers: { 'Content-Type': 'application/json' },
    body: JSON.stringify({
      name: document.getElementById('name').value,
      phoneNumber: document.getElementById('phone').value
    })
  }).then(res => {
     if(!res.ok) {
       res.text().then(msg => alert("Error: " + msg));
     } else {
       location.reload();
     }
  });
};

// 3. Update an account
function updateAcc(id, currentName, currentPhone) {
  const newName = prompt(`Enter new name:`, currentName);
  if (newName === null) return; 
  
  const newPhone = prompt(`Enter new phone:`, currentPhone);
  if (newPhone === null) return;

  fetch(`/account/${id}`, {
      method: 'PUT',
      headers: { 'Content-Type': 'application/json' },
      body: JSON.stringify({ name: newName, phoneNumber: newPhone })
  }).then(() => location.reload()); // Simple refresh
}

// 4. Delete an account
function del(id) {
  fetch('/account/' + id, { method: 'DELETE' })
    .then(() => location.reload());
}
