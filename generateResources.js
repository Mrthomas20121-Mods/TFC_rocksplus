const fs = require('fs');

let langEntries = '';

let ROCK_TYPES = [
  'blaimorite',
  'boninite',
  'carbonatite',
  'foidolite',
  'arkose',
  'jaspillite',
  'travertine',
  'wackestone',
  'blueschist',
  'greenschist',
  'cataclasite',
  'mylonite'
]

let ORE_TYPES = {
  'native_copper': true,
  'native_gold': true,
  'native_platinum': true,
  'hematite': true,
  'native_silver': true,
  'cassiterite': true,
  'galena': true,
  'bismuthinite': true,
  'garnierite': true,
  'malachite': true,
  'magnetite': true,
  'limonite': true,
  'sphalerite': true,
  'tetrahedrite': true,
  'bituminous_coal': false,
  'lignite': false,
  'kaolinite': false,
  'gypsum': false,
  'satinspar': false,
  'selenite': false,
  'graphite': false,
  'kimberlite': false,
  'petrified_wood': false,
  'sulfur': false,
  'jet': false,
  'microcline': false,
  'pitchblende': false,
  'cinnabar': false,
  'cryolite': false,
  'saltpeter': false,
  'serpentine': false,
  'sylvite': false,
  'borax': false,
  'olivine': false,
  'lapis_lazuli': false,
  'native_ardite': true,
  'rutile': true,
  'native_osmium': true,
  'bauxite': true,
  'wolframite': true,
  'cobaltite': true,
  'thorianite': false,
  'chromite': false,
  'pyrolusite': false,
  'magnesite': false,
  'boron': false,
  'spodumene': false,
  'stibnite': false
}
let FULLBLOCK_TYPES = [
  'raw',
  'smooth',
  'cobble',
  'bricks',
  'sand',
  'gravel',
  'dirt',
  'clay',
]
let GRASS_TYPES = [
  'grass',
  'dry_grass',
  'clay_grass',
  'path',
  'FarmLand'
]

let DECORATION_TYPES = [
  'stairs',
  'stab',
  'double_slab'
]

function capitalizeFirstLetter(str) {
  return str.charAt(0).toUpperCase() + str.slice(1);
}


for (let rockType of ROCK_TYPES) {
  langEntries = langEntries.concat(`# ${rockType}\n`)

  // spikes
  langEntries = langEntries.concat(`tile.tfc.spike.${rockType}.name=${capitalizeFirstLetter(rockType)} Spike \n`)

  for (let blockType of FULLBLOCK_TYPES) {
    langEntries = langEntries.concat(`tile.tfc.${blockType}.${rockType}.name=${capitalizeFirstLetter(blockType)} ${capitalizeFirstLetter(rockType)}\n`)
  }
  for (let grassType of GRASS_TYPES) {
    if(!['FarmLand', 'grass', 'path'].includes(grassType))
    langEntries = langEntries.concat(`tile.tfc.${grassType.toLowerCase()}.${rockType}.name=${capitalizeFirstLetter(rockType)} ${capitalizeFirstLetter(grassType.split('_')[0])} ${capitalizeFirstLetter(grassType.split('_')[1])}\n`)
    else {
      langEntries = langEntries.concat(`tile.tfc.${grassType.toLowerCase()}.${rockType}.name=${capitalizeFirstLetter(rockType)} ${capitalizeFirstLetter(grassType)}\n`);
    }
  }

  for (let decorationType of DECORATION_TYPES) {
    for (type of ['smooth', 'cobble', 'bricks']) {
      if(decorationType == 'double_slab') {
        langEntries = langEntries.concat(`tile.tfc.${decorationType.toLowerCase()}.${type}.${rockType}.name=${capitalizeFirstLetter(type)} ${capitalizeFirstLetter(rockType)} ${capitalizeFirstLetter(decorationType.split('_')[0])} ${capitalizeFirstLetter(decorationType.split('_')[1])}\n`)
      }
      else {
        langEntries = langEntries.concat(`tile.tfc.${decorationType.toLowerCase()}.${type}.${rockType}.name=${capitalizeFirstLetter(type)} ${capitalizeFirstLetter(rockType)} ${capitalizeFirstLetter(decorationType)}\n`);
      }
    }
  }
  for (let oreType of Object.keys(ORE_TYPES)) {
    if(oreType.includes('_')) {
      langEntries = langEntries.concat(`tile.tfc.ore.${oreType.toLowerCase()}.${rockType}.name=${capitalizeFirstLetter(rockType)} ${capitalizeFirstLetter(oreType.split('_')[0])} ${capitalizeFirstLetter(oreType.split('_')[1])}\n`);
    }
    else {
      langEntries = langEntries.concat(`tile.tfc.ore.${oreType.toLowerCase()}.${rockType}.name=${capitalizeFirstLetter(rockType)} ${capitalizeFirstLetter(oreType)}\n`);
    }
  }
}

console.log(langEntries);

fs.writeFileSync('./src/main/resources/assets/tfc/lang/en_us.lang', langEntries,'utf8');