const path = require("path");
const CopyWebpackPlugin = require("copy-webpack-plugin");

module.exports = {
  mode: "production",
  entry: "./src/main/typescript/main.ts",
  devServer: {
    contentBase: path.join(__dirname, "src/main/webapp/templates"),
    port: 3000,
    hot: true,
  },
  output: {
    filename: "app.min.js",
    path: path.join(__dirname, "src/main/webapp/templates"),
  },
  resolve: {
    extensions: [".ts", ".js"],
  },
  plugins: [new CopyWebpackPlugin({ patterns: [{ from: "src/main/resources/public" }] })],
  module: {
    rules: [
      {
        test: /.ts$/,
        use: "ts-loader",
        exclude: /node_modules/,
      },
    ],
  },
};
