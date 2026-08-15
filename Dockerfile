FROM node:24-alpine

WORKDIR /app

COPY . .

# lệnh RUN sẽ chạy trong lúc build image
RUN npm install
RUN npm run build

# lệnh auto khi start container
CMD ["npm","start"]