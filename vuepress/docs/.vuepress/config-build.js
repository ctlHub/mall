const fs = require('fs')
const path = require('path')
const root = path.resolve(__dirname, '..')
const excludes = ['.vuepress', 'README.md']
let config = require('./config-temp')
let nav = config.themeConfig.nav
let sidebar = {}
let dirs = fs.readdirSync(root)

for (let i = 0; i < dirs.length; i++) {
  let dir = dirs[i]
  if (excludes.includes(dir)) continue
  let file = path.resolve(root, dir)
  let stat = fs.statSync(file)
  if (stat.isDirectory()) {
    sidebar[`/${dir}/`] = []
    let fileList = fs.readdirSync(path.resolve(root, dir))
    let navItem
    nav.forEach(ele => {
      if (ele.link.substr(1, ele.link.length - 2) == dir) {
        navItem = ele
      }
    })
    for (let j = 0, len = fileList.length; j < len; j++) {
      let fileItem = fileList[j]
      if (fileItem !== 'README.md') {
        sidebar[`/${dir}/`].push(`${fileItem}`)
        if (navItem && j === 0) {
          navItem.link += fileItem.substr(0, fileItem.length - 3)
        }
      }
    }
  }
}
config.themeConfig.sidebar = sidebar
let fileContent = `module.exports = ${JSON.stringify(config)}`

fs.writeFileSync(path.resolve(__dirname, 'config.js'), fileContent, 'UTF-8')

