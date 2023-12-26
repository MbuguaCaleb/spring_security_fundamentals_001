**Application Level security**

```agsl

Security in application opens the door to pull the resource if the correct credentials
are added.

1.Autheniticaton-->Are you who you claim you are

Types

1.Http Basic
2.Cerification
3.OAUTH2.O Such as JWT

2.Authorization (Checks permissions [Roles and Granted Authorties])

1.WEB Application-->we use filters
2.Other apps-->We use aspects.


```

**Authorization**


**Http Basic**

```agsl

Any spring boot project with spring security is preconfigured with Http Basic,

We use a http Authorization Header that is base64 encoded,

As we make requests to reseources that are base64 encoded, we must have the above header implemented

Base 64 is an encoding,not an encryption.

```

**Encoding/Encryption/HashFunctions**

```agsl

(a)Encoding-->Is always a function that is possible to reverse somehow,It can be a mathematicatal transformation.
that doesnt need a secret to be known to revert it.

All i need to revert an encoding is to know the Rule.

You can always revert the OUTPUT to know the Input if you know the rule.
You do not always need a secret when encoding.

(b)Encryption->You are transforming and input to an OutPut,but to go back from the Output to the input,you
always need a secret.

Not eveyrone is able to find what was the input after an encryption function,they must have the secret

(c)Hashed Functions->From the Input in a hashed function, you can find the Output, but from the 
Output you can never find the Input Again.

When using a hash function you can however check if a partucular input corresponds to an outPut or not

You cannot go back from the Output to the Input, but if you have the input,

Hashed functions are usually the preferred way to store passwords.This is because there is no way to go
back to the password even when someone accesses them from the DB.

Hashing functions should not produce the same out put for the same input.
```

**Custom HttpBasic Implementation**

**UserDetailsService**

```agsl
UserDetails Service, It is where we tell Spring to get our user details from.

It is the compoonent we implement in our web application to tell spring security where to get
our credentials from.

```

**Spring security autoconfiguration(Abstracted Functionality)**

```agsl

We enforce security in our resources in the below process.

Wr first begin by a filter, that is like a middleware
1.HttpBasic Authentication Filter->This filter is part of a security chain, and 
we also have the security context, where the authentication goes after a successful
authenitication.

2.Authenitication manager. (Calls the authentication Provider)

3.Authenitication Provider
    Where we define the authenitcation Logic, i.e check whether  the username 
    and password provided is correct.
    
    You can have more than one authenitcation provider.
    
   (uses the userDetailService and the passwordEncorder)

Spirng boot precongigures all these beans out of the Box.

4.UserDetailsService.

Provides the spring security context with details about the user,

Gives me the autonomy of even storing my users in the database.

All we need to do is to provide the userDetails service implementation for that

5.Password Encoder.

It validates the hashed or encrypted password.

6.Security Context.
If the authentication is successful and the authentocation filter has veirifed
corretness, It stores the athentication object in the security context.

Remember the authentication Object has things like the Role and the Granted-Authority,

```

**Lesson Two**

```agsl

Create our own 
```