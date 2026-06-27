import "./NetflixIndexComponent.css";
import NetflixHeaderComponent from "./NetflixHeaderComponent.jsx";
import NetflixMainComponent from "./NetflixMainComponent.jsx";
import NetflixRegisterComponent from "./NetflixRegisterComponent.jsx";
import NetflixFooterComponent from "./NetflixFooterComponent.jsx";
export default function NetflixIndexComponent() {
  return (
    <>
      <div className="container-fluid">
        <div className="box">
          <header>
            <NetflixHeaderComponent />
          </header>
          <section className="d-flex justify-content-center align-items-center h-75">
            <main className="text-blue-50 text-center">
              <NetflixMainComponent />
              <NetflixRegisterComponent />
            </main>
          </section>

          <footer>
              <NetflixRegisterComponent />

            <NetflixFooterComponent/>
          </footer>
        </div>
      </div>
    </>
  );
}
