## Table of Contents

* 1.0 Prerequisites
* 2.0 Installation
* 2.1 Run Ant to install libraries required for compilation
* 2.2 Verify installation
* 3.0 Development Guidelines



### 1.0 Prerequisites
Your computer must have Ant 1.8.1 and Java 1.6 installed.

### 2.0 Installation
#### 2.1 Run Ant to install libraries required for compilation
Upon checkout out of the sources from SVN, or else downloading the distribution, you must start by invoking "ant" at the top level of the project:
```
% ant
```

This will do the following:
* Download Ivy.
* Use Ivy to download packages required for compilation, including JUnit and Robocode.
* Compile the system.

If you cannot successfully compile the system, please contact does not succeed, then contact our team for help before proceeding.


#### 2.2 Verify installation
Once compilation is successful, perform a "verification" of the system as follows:

```
% ant -f verify.build.xml
```

This command will run JUnit, Checkstyle, PMD, JavaDoc, and FindBugs, and fail the build if any warnings are issued by these tools. It will also download these packages using Ivy.

If the verification does not succeed, review your modifications to the code to make sure they adhere to the style and formatting guidelines of Checkstyle, Javadocs and PMD. Review your JUnit test cases and FindBugs output if these cause verification to fail.

Alternatively, you can contact our team for help before proceeding.


### 3.0 Development Guidelines

Once you have verified your local installation of solar-decathlon-team3, you are ready for development. We follow these development guidelines:

* We use Eclipse for development, and format the code using this format.
* For new features, please add an Issue that specifies what you plan to do.
* Please develop a JUnit test case (either before, during, or after) development of a new feature to ensure it works.
* Before committing changes, please make sure that "ant -f verify.build.xml" runs successfully.

