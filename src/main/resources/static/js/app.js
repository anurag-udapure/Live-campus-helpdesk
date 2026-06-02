const API_URL = "http://localhost:8080/tickets";

let stompClient = null;

// CONNECT WEBSOCKET
function connectWebSocket() {

    const socket = new SockJS('/ws');

    stompClient = Stomp.over(socket);

    stompClient.connect({}, function () {

        console.log("WebSocket Connected");

        stompClient.subscribe('/topic/tickets', function () {

            loadTickets();
        });
    });
}

// ADD TICKET
async function submitTicket() {

    const studentName =
        document.getElementById("studentName").value;

    const issue =
        document.getElementById("issue").value;

    if(studentName === "" || issue === "") {

        alert("Please fill all fields");

        return;
    }

    const ticket = {

        studentName: studentName,
        issue: issue
    };

    await fetch(API_URL, {

        method: "POST",

        headers: {
            "Content-Type": "application/json"
        },

        body: JSON.stringify(ticket)
    });

    document.getElementById("studentName").value = "";

    document.getElementById("issue").value = "";
}

// LOAD TICKETS
async function loadTickets() {

    const response = await fetch(API_URL);

    const tickets = await response.json();

    const ticketList =
        document.getElementById("ticketList");

    ticketList.innerHTML = "";

    let pending = 0;
    let resolved = 0;

    tickets.forEach(ticket => {

        let statusClass =
            ticket.status === "RESOLVED"
            ? "resolved"
            : "pending";

        if(ticket.status === "RESOLVED") {
            resolved++;
        } else {
            pending++;
        }

        ticketList.innerHTML += `

            <div class="ticket-card">

                <h3>${ticket.studentName}</h3>

                <p>${ticket.issue}</p>

                <p class="status ${statusClass}">
                    Status: ${ticket.status}
                </p>

                <button onclick="resolveTicket(${ticket.id})">
                    Resolve
                </button>

                <button onclick="deleteTicket(${ticket.id})">
                    Delete
                </button>

            </div>
        `;
    });

    document.getElementById("totalCount").innerText =
        tickets.length;

    document.getElementById("pendingCount").innerText =
        pending;

    document.getElementById("resolvedCount").innerText =
        resolved;
}

// UPDATE STATUS
async function resolveTicket(id) {

    await fetch(API_URL + "/" + id + "?status=RESOLVED", {

        method: "PUT"
    });
}

// DELETE
async function deleteTicket(id) {

    await fetch(API_URL + "/" + id, {

        method: "DELETE"
    });
}

// INITIAL LOAD
connectWebSocket();

loadTickets();