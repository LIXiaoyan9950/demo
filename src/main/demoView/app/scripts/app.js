var routerApp = angular.module('routerApp', ['ui.router']);

routerApp.config(function($stateProvider, $urlRouterProvider,$httpProvider) {
  $httpProvider.defaults.headers.put['Content-Type'] = 'application/json; charset=UTF-8';
  $httpProvider.defaults.headers.post['Content-Type'] = 'application/json; charset=UTF-8';
  $httpProvider.defaults.headers.put['Content-Type'] = 'application/json; charset=UTF-8';
  $httpProvider.defaults.headers.common['Authorization'] = 'Basic cGF1bDoxMTExMTE=';
  $httpProvider.defaults.transformRequest = [function(data) {
    /**
     * The workhorse; converts an object to x-www-form-urlencoded serialization.
     * @param {Object} obj
     * @return {String}
     */
    var param = function(obj) {
      var query = '';
      var name, value, fullSubName, subName, subValue, innerObj, i;

      for (name in obj) {
        value = obj[name];

        if (value instanceof Array) {
          for (i = 0; i < value.length; ++i) {
            subValue = value[i];
            fullSubName = name + '[' + i + ']';
            innerObj = {};
            innerObj[fullSubName] = subValue;
            query += param(innerObj) + '&';
          }
        } else if (value instanceof Object) {
          for (subName in value) {
            subValue = value[subName];
            fullSubName = name + '[' + subName + ']';
            innerObj = {};
            innerObj[fullSubName] = subValue;
            query += param(innerObj) + '&';
          }
        } else if (value !== undefined && value !== null) {
          query += encodeURIComponent(name) + '='
            + encodeURIComponent(value) + '&';
        }
      }

      return query.length ? query.substr(0, query.length - 1) : query;
    };

    return angular.isObject(data) && String(data) !== '[object File]'
      ? param(data)
      : data;
  }];
  $urlRouterProvider.otherwise('/home');

  $stateProvider
    .state('home', {
      url: '/home',
      views: {
        '': {
          templateUrl: 'partial-home.html',
          controller:homeController,
        }
      },
      data:{
        title:'X-PreTrade'
      }
    })
});

function homeController($scope,$http){
  $scope.accountName="adle"
  $scope.newpassword="222222"
  $scope.username="测试"
  var dataObj = {
    accountId: 16,
    accountName : "adle43",
    newpassword : "111111",
    username : "测试66"
  };

  jsonDataObj = JSON.stringify(dataObj);

  $http.get("http://localhost:8088/index/1").success(function (data, status, headers, config) {
    console.log(data)
  }).error(function (e) {
    console.log(e)
  })
}
