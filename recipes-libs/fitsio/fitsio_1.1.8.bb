SUMMARY = "A full featured python library to read from and write to FITS files."
HOMEPAGE = "https://github.com/esheldon/fitsio"

LICENSE = "GPL & GPL-2.0-only & Unknown"
LIC_FILES_CHKSUM = "file://LICENSE.txt;md5=eb723b61539feef013de476e68b5c50a \
                    file://cfitsio3490/License.txt;md5=77856e8a5492e2119200b3401a8e7966"

SRC_URI[md5sum] = "544b6bd805878ef56f62a930858adf86"
SRC_URI[sha256sum] = "61f569b2682a0cadce52c9653f0c9b81f951d000522cef645ce1cb49f78300f9"

inherit pypi setuptools3

PYPI_PACKAGE = "fitsio"

SRC_URI += "file://system_cfitsio.patch"

DEPENDS += "python3-pip-native python3-numpy-native cfitsio"

RDEPENDS:${PN} += " python3-core python3-io python3-numpy cfitsio python3-setuptools python3-pprint python3-unittest"

ERROR_QA:remove = "license-file-missing"
