import './App.css';

function Food(props){
  return (
    <div>
    <h2>I love {props.name}!</h2>
    <img src ={props.picture} alt={props.name}/>
    </div>
  );
}

const foodILike = [
  {
    name: 'potato',
    image : 'https://place-hold.it/200x100/'
  },
  {
    name: 'sweet potato',
    image : 'https://place-hold.it/200x200/'
  },
  {
    name: 'apple',
    image : 'https://place-hold.it/200x300/'
  }
];

function App() {
  return (
    <div>
    <h1><em>Hello React!</em></h1>
    {foodILike.map((fruit)=>
    (<Food name={fruit.name} picture={fruit.image} />
    ))}
    </div>
  );
}

export default App;
