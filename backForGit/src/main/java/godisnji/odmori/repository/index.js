import React from "react";
import ReactDOM from "react-dom";
import {
  Route,
  Link,
  HashRouter as Router,
  Switch,
  Redirect,
} from "react-router-dom";
import Home from "./components/Home";
import NotFound from "./components/NotFound";
import { Container, Navbar, Nav, Button, Form } from "react-bootstrap";
import Login from "./components/authentication/Login";
import { logout } from "./services/auth";
import Radnici from "./components/radnici/Radnici";
import Radnik from"./components/radnici/Radnik";
import Odsustvo from "./components/odsustva/Odsustvo";
import Odeljenja from "./components/odeljenja/Odeljenja";
import Odeljenje from "./components/odeljenja/Odeljenje";
import Odsustva from "./components/odsustva/Odsustva";
import Praznici from"./components/praznici/Praznici";
class App extends React.Component {
  render() {
    let token = window.localStorage.getItem("token");

    if (token) {
      return (
        <div>
          <Router>
            <Navbar bg="dark" variant="dark" expand>
              <Navbar.Brand as={Link} to="/">
                JWD
              </Navbar.Brand>
              <Nav className="mr-auto">
                <Nav.Link as={Link} to="/radnici">
                  Radnici
                </Nav.Link>
              </Nav>
              <Nav className="mr-auto">
              <Nav.Link as={Link} to="/odeljenja">
                Odeljenja
              </Nav.Link>
            </Nav>
            <Nav className="mr-auto">
            <Nav.Link as={Link} to="/praznici">
              Praznici
            </Nav.Link>
          </Nav>
              <Button
                onClick={() => {
                  logout();
                }}
                variant="outline-info"
              >
                Log Out
              </Button>
            </Navbar>

            <Container style={{marginTop:25}}>
              <Switch>
                <Route exact path="/" component={Home} />
                <Route exact path="/radnici" component={Radnici} />
                <Route exact path="/radnik" component={Radnik} />
                <Route exact path="/odeljenja" component={Odeljenja} />
                <Route exact path="/praznici" component={Praznici} />
                <Route exact path="/odsustvas/:id" component={Odsustva} />
                <Route exact path="/odeljenje" component={Odeljenje} />
                <Route exact path="/odeljenje/:id" component={Odeljenje} />
                <Route exact path="/odsustvo/:id" component={Odsustvo} />
                <Route exact path="/login">
                  <Redirect to="/"></Redirect>
                </Route>
                <Route component={NotFound} />
              </Switch>
            </Container>
          </Router>
        </div>
      );
    } else {
      return (
        <Router>
          <Container>
            <Switch>
              <Route exact path="/login" component={Login}></Route>
              <Route path="/">
                <Redirect to="/login"></Redirect>
              </Route>
            </Switch>
          </Container>
        </Router>
      );
    }
  }
}

ReactDOM.render(<App />, document.querySelector("#root"));
