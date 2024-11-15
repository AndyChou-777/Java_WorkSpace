const MyHello = () => {
  return <h1>Hello React</h1>
};

const MyWelcome = () => {
  const text = 'John'
  return <h1>Hello {text} !</h1>
};

const MyGreet = (props) => {
  const name = props.name
  const age = props.age
  return <h1>Hello {name} {age} !</h1>
};

const getBmiStatus = (bmi) => {
  if (bmi < 18){
    return "過輕"
  } else if (bmi > 23) {
    return "過重"
  }
};

const MyBMI = (props) => {
  const {username, userage, h, w} = props;
  const bmi = (w/ (h*h)).toFixed(2);
  // 加上 bmi 判斷 bmi < 18 過輕, bmi > 23 過重, 其餘正常
  return <h1>Hello {username} {userage} {bmi} {getBmiStatus(bmi)}!</h1>
};

function App() {

  return (
    <>

      <MyHello />
      <MyWelcome />
      <MyGreet name="Mary" age="18" />
      <MyBMI username="Mary" userage="18" h="1.6" w="45" />
    </>
  )
}

export default App
