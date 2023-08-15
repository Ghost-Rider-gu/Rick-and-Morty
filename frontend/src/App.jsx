import Container from 'react-bootstrap/Container';
import Row from 'react-bootstrap/Row';
import Header from "./component/Header.jsx";
import Footer from "./component/Footer.jsx";

import './App.css'

function App() {
  return (
      <Container fluid>
          <Row>
              <Header/>
          </Row>
          <Row>
              Main context
          </Row>
          <Row>
              <Footer/>
          </Row>
      </Container>
  )
}

export default App
