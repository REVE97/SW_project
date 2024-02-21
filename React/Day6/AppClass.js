
import React from "react";

class AppClass extends React.Component{
    
    state = {
        count :0,
    };

    add = () => {
        console.log('add');
        //this.state.count = 1;
        this.setState({count: this.state.count +1});
    };

    minus = () => {
        console.log('minus');
        //this.state.count = -1;
        this.setState({count: this.state.count -1});
    };
    
    render(){
        return (
            <div>
                <h1>The number is : {this.state.count}</h1>
                <button onClick={this.add}>Add</button>
                <button onClick={this.minus}>Minus</button>
            </div>
        )
    }
}

export default AppClass;
