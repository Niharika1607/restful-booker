function fn() {
  var env = karate.env; // get java system property 'karate.env'
  karate.log('karate.env system property was:', env);
  if (!env) {
    env = 'dev'; // a custom 'intelligent' default
  }
  var config = { // base config JSON
    appId: 'my.app.id',
    baseUrl: 'https://restful-booker.herokuapp.com/booking/',

  };
  if (env == 'stage') {
    // over-ride only those that need to be
    config.someUrlBase = 'https://stage-host/v1/auth';
  } else if (env == 'e2e') {
    config.baseUrl = 'https://e2e-host/v1/auth';
  }
  // don't waste time waiting for a connection or if servers don't respond within 5 seconds
  //The connection timeout is the timeout in making the initial connection; i.e. completing the TCP connection handshake.
  //The read timeout is the timeout on waiting to read data
  karate.configure('connectTimeout', 10000);
  karate.configure('readTimeout', 10000);
  return config;
}