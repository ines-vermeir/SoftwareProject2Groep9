<!DOCTYPE html>
<html>

<head>
    <title>Human Resource</title>

    <link href="https://fonts.googleapis.com/css?family=Lato:100" rel="stylesheet" type="text/css">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/css/bootstrap.min.css" integrity="sha384-PsH8R72JQ3SOdhVi3uxftmaW6Vc51MKb0q5P2rRUpPvrszuE4W1povHYgTpBfshb" crossorigin="anonymous">
    <style>
        html,
        body {
            height: 100%;
        }
        
        body {
            margin: 0;
            padding: 0;
            width: 100%;
            display: table;
            font-weight: 100;
            font-family: 'Lato';
        }
        
        .container {
            text-align: center;
            display: table-cell;
            vertical-align: middle;
        }
        
        .content {
            text-align: center;
            display: inline-block;
        }
        
        .title {
            font-size: 96px;
        }

    </style>
</head>

<body>
    <div class="container">
        <div class="content">
            <div class="title">HumanResource</div>
            <a href="{{ url('/admin/login') }}"><button  type="button" class="btn btn-primary">Login</button></a>
            <a href="{{ url('/admin/register') }}"><button  type="button" class="btn btn-primary">Register</button></a>
        </div>
    </div>
</body>

</html>
