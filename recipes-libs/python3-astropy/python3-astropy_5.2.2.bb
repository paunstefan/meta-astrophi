DESCRIPTION = "Astropy."
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

PYPI_PACKAGE = "astropy"
inherit pypi

DEPENDS += "python3-astropy-helpers"

SRC_URI[md5sum] = "b39c63a97172f5bf40961c4c836d998f"
SRC_URI[sha256sum] = "e6a9e34716bda5945788353c63f0644721ee7e5447d16b1cdcb58c48a96b0d9c"
