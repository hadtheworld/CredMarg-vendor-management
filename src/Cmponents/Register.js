import React, { useEffect, useState } from "react";
import { Modal } from "react-bootstrap";
import axios from "axios";

function Register(props){
    // const [isVendor, setIsVendor] = useState(false);
    const [errMsg, setErrMsg] = useState("");
    const [showEmpRegister, setShowEmpRegister] = useState(false);
    const [showVendorRegister, setShowVendorRegister] = useState(false);
    const [vendors,setVendors] =useState([]);
    const [employee,setEmployee] = useState([]);
    const [emails,setEmail]=useState([]);

    const emplyeeRegister = async (event) => {
        event.preventDefault();
        console.log(event.target.empCTC.value);
          await axios
            .post("http://localhost:8081/employee", {
              empName: event.target.empName.value,
              empEmail: event.target.empEmail.value,
              empDesignation: event.target.empDesignation.value,
              empCTC: event.target.empCTC.value,
            })
            .then(
              () => {
                setErrMsg("");
                setShowEmpRegister(false);
                window.location.reload();
              },
              (error) => {
                setErrMsg(error.response.data);
              }
            );
        
      };
    const vendorRegister = async (event) => {
        event.preventDefault();
        // console.log(event.target.empCTC.value);
          await axios
            .post("http://localhost:8081/vendor", {
              vadorName: event.target.vendorName.value,
              vendorEmail: event.target.vendorEmail.value,
              upi: event.target.upi.value
            })
            .then(
              () => {
                setErrMsg("");
                setShowVendorRegister(false);
                window.location.reload();
              },
              (error) => {
                setErrMsg(error.response.data);
              }
            );
        
      };

      const sendMail=async (vendorId,vendorName,upi)=>{
        await axios
            .post(`http://localhost:8081/vendor/${vendorId}/email`, {
                emialSent: `Sending payments to vendor ${ vendorName } at upi ${ upi }`
            }).then(
                (response) => {
                  setErrMsg("");
                  console.log(response.data.emialSent);
                },
                (error) => {
                  setErrMsg(error.response);
                }
              );
      };

      const seeAllMail=async (vendorId)=>{
        readToggle(vendorId);
        
        const email=(await axios
            .get(`http://localhost:8081/vendor/${vendorId}/email`)).data;
            setEmail(email);
      }
      useEffect(() => {
        async function getRegistered() {
            const vendors = (await axios.get("http://localhost:8081/vendor"))
              .data;
            setVendors(vendors);
            const employee=(await axios.get("http://localhost:8081/employee")).data;
            setEmployee(employee)
            setErrMsg("");
        }
        getRegistered();
      }, [employee.length,vendors.length]);

      const emailCards = emails.map((prop)=>{
        return (
                <h5>
                  Email:-{prop.emialSent}
                </h5>
                
          );
      })

      const readToggle = (propId) => {
        setVendors((vendors) =>
          vendors.map((prop) => {
            if (prop.vendorId === propId) {
              return {
                ...prop,
                toBeVisible: !prop.toBeVisible,
              };
            }
            return prop;
          })
        );
      };
      const cards = vendors.map((prop) => {
        return (
          <div class="card text-center" key={prop.vendorId}>
            <div class="card-header">Name: {prop.vadorName}</div>
            <div class="card-body">
              <h5 class="card-text">
                Email:-{prop.vendorEmail}
              </h5>
              <h5 class="card-text">
                UPI:-{prop.upi}
              </h5>
            </div>
            <button
            class="btn btn-primary"
            onClick={() => sendMail(prop.vendorId,prop.vadorName,prop.upi)}
          >
            Send Mail
          </button>
            <button
            class="btn btn-primary"
            onClick={() => seeAllMail(prop.vendorId)}
          >
            See All Mail
          </button>
          {prop.toBeVisible? emailCards : ""}
          </div>
        );
      });
      const empCards = employee.map((prop) => {
        return (
          <div class="card text-center" key={prop.empId}>
            <div class="card-header">Name: {prop.empName}</div>
            <div class="card-body">
              <h5 class="card-text">
                Email:-{prop.empEmail}
              </h5>
              <h5 class="card-text">
                Desigation:-{prop.empDesignation}
              </h5>
              <h5 class="card-text">
                CTC:-{prop.empCTC}
              </h5>
            </div>
          </div>
        );
      });

    const  toggleEmpRegister=()=>{
        setShowEmpRegister(true);
    }
    const  toggleVendorRegister=()=>{
        setShowVendorRegister(true);
    }
    return (
        <div>
             <button class="btn btn-primary" onClick={toggleEmpRegister}>
                  Employee Register
                </button>
             <button class="btn btn-primary" style={{marginLeft: '10px'}} onClick={toggleVendorRegister}>
                  Vendor Register
                </button>
            <Modal show={showEmpRegister}>
        <Modal.Header closeButton>
          <Modal.Title>Register</Modal.Title>
        </Modal.Header>
        <Modal.Body>
          <form onSubmit={emplyeeRegister}>
            <div class="form-group">
              <label for="empName">Name:</label>
              <input
                type="text"
                class="form-control"
                id="empName"
                autoComplete="off"
                placeholder="Enter your name"
              />
            </div>
            <div class="form-group">
              <label for="empEmail">Email:</label>
              <input
                type="email"
                class="form-control"
                id="empEmail"
                autoComplete="off"
                placeholder="Enter your email"
              />
            </div>
            <div class="form-group">
              <label for="empDesignation">Designation:</label>
              <input
                type="text"
                class="form-control"
                id="empDesignation"
                placeholder="Enter your Designation"
              />
            </div>
            <div class="form-group">
              <label for="empCTC">CTC:</label>
              <input
                type="text"
                class="form-control"
                id="empCTC"
                autoComplete="off"
                placeholder="Enter your CTC"
              />
            </div>
            <div class="form-group row">
              <div class="col-sm-10">
                <button type="submit" class="btn btn-primary">
                  Employee Register
                </button>
              </div>
            </div>
          </form>
          
          {errMsg.length > 0 ? (
            <div className="error-message">{errMsg}</div>
          ) : (
            ""
          )}
        </Modal.Body>
      </Modal>
            <Modal show={showVendorRegister}>
        <Modal.Header closeButton>
          <Modal.Title>Vendor Register</Modal.Title>
        </Modal.Header>
        <Modal.Body>
          <form onSubmit={vendorRegister}>
            <div class="form-group">
              <label for="vendorName">Name:</label>
              <input
                type="text"
                class="form-control"
                id="vendorName"
                autoComplete="off"
                placeholder="Enter your name"
              />
            </div>
            <div class="form-group">
              <label for="vendorEmail">Email:</label>
              <input
                type="email"
                class="form-control"
                id="vendorEmail"
                autoComplete="off"
                placeholder="Enter your email"
              />
            </div>
            <div class="form-group">
              <label for="upi">UPI:</label>
              <input
                type="text"
                class="form-control"
                id="upi"
                autoComplete="off"
                placeholder="Enter your UPI"
              />
            </div>
            <div class="form-group row">
              <div class="col-sm-10">
                <button type="submit" class="btn btn-primary">
                  Vendor Register
                </button>
              </div>
            </div>
          </form>
          
          {errMsg.length > 0 ? (
            <div className="error-message">{errMsg}</div>
          ) : (
            ""
          )}
        </Modal.Body>
      </Modal>
      <div className="container-fluid card-style">
        <div class="row">
            <div class="col">
                <h1>Vendors</h1>
            {cards}
            </div>
            <div class="col">
                <h1>Employees</h1>
                {empCards}
            </div>

        </div>
        
      </div>
    </div>
    );
}

export default Register