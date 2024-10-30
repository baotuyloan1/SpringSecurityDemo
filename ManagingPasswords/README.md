Where the PasswordEncoder fits into the authentication process.
![img.png](img.png)
The AuthenticationProvider uses the PasswordEncoder to validate the user's password in the authentication process.</br></br>
Because in general, a system doesn't manage password in plain text, these usually undergo a sort of transformation that makes it more challenging to read and steal them. For this responsibility, Spring Security defines a separate contract. 
To explain it simply in this section. I provide plenty of code examples related to the PasswordEncoder implementation. We'll start with understanding the contract, and then we'll write our implementation in a project.</br></br>
1. PasswordEncoder contract</br>
In this section, we discuss the definition of the PasswordEncoder contract. You implement this contract to tell Spring Security how to validate a user's password. In the authentication process, the PasswordEncoder decides whether a password is valid. 
Every system stores passwords encoded in some way. You preferably store them hashed so that there's no chance someone can read them. The PasswordEncoder can also encode passwords. The method encode() and matches(), which the contract declares, are actually the definition of its responsibility. Both are parts of the same contract because these are strongly interlinked.
The way the application encodes a password is related to the way the password is validated. Let's first review the contents of the PasswordEncoder interface:

```java
public interface PasswordEncoder{
    String encode (CharSequence rawPassword);
    boolean matches (CharSequence rawPassword, String encodedPassword);
    
        default boolean upgradeEncoding(String encodedPassword){
        return false;
    }
}
```
The interface defines two abstract methods and one with a default implementation.
The abstract encode() and matches() methods are also the ones that you most often here about when dealing with a PasswordEncoder implementation.</br>
The purpose of the encode (CharSequence rawPassword) method is to return a transformation of a provided string. In terms of Spring Security functionality, it's used to provide encryption or a hash for a given password. You can use the matches (CharSequence rawPassword, String encodedPassword) method afterward to check whether an encoded string matches a raw password. 
You use the matches() method in the authentication process to test a provided password against a set of known credentials. The third method, called upgradeEncoding(String encodedPassword), defaults to false in the contract. 
If you override it to return true, then the encoded-password is encoded again for better security.</br></br>
In some cases, encoding the encoded password can make it more challenging to obtain the cleartext password from the result. In general, this is a kind of obscurity that I personally don't like. But the framework offers this possibility if you think it applies to your case.
2. Implementing your PasswordEncoder:</br>
As you observed, the two methods matches() and encode() have a strong relationship. If you override them, you should always correspond in terms of functionality: a string returned by the encode() method should always be verifiable with the matches() method of the same PasswordEncoder. 
In this section, you'll implement the PasswordEncoder contract and define the two abstract methods declared by the interface. Knowing how to implement the PasswordEncoder, you can choose how the application manages passwords for the authentication process. The most straightforward implementation is a password encoder that considers passwords in a plain text: that is, it doesn't do any encoding on the password.</br>
Managing passwords in cleartext is what the instance of NoOpPasswordEncoder is percisely. It would look something like the following listing.
```java
public class PlainTextPasswordEncoder implements PasswordEncoder {
    
    @Override
    public String encode(CharSequence rawPassword){
        return rawPassword.toString();
    }
    
    @Override
    public boolean matches(CharSequence rawPassword, String encodedPassword){
        return rawPassword.equals(encodedPassword);
    }
}
```
The result of encoding is always the same as the password. SO to check if these match, you only need to compare the strings with equals(). A simple implementation of PasswordEncoder that uses the hashing algorithm SHA-512 looks like:

```java

public class Sha512PasswordEncoder implements PasswordEncoder {
    @Override
    public String encode(CharSequence rawPassword) {
        return hashWithSHA512(rawPassword.toString());
    }

    private String hashWithSHA512(String password) {
        StringBuilder result = new StringBuilder();
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-512");
            byte[] digested = md.digest(password.getBytes());
            for (byte b : digested) {
                result.append(Integer.toHexString(0xFF & b));
            }
        }catch (NoSuchAlgorithmException e){
            throw new RuntimeException("Bad algorithm");
        }
        return result.toString();
    }

    @Override
    public boolean matches(CharSequence rawPassword, String encodedPassword) {
        String hashedPassword = encode(rawPassword);
        return encodedPassword.equals(hashedPassword);
    }
}

```
We use a method to hash the string value provided with SHA-512. I omit the implementation of this method.
We can call this method from the encode() method, which now returns the hash value for its input. To validate a hash against an input, the matches() method hashes the raw password in its input and compares it for equality with the hash against which it does the validation.
3. Choosing from the provided PasswordEncoder implementations:</br>
PasswordEncoder is powerful, you must also be aware that Spring Security already provides you  with some advantageous implementations